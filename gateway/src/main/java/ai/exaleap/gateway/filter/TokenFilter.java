package ai.exaleap.gateway.filter;

import ai.exaleap.gateway.config.AuthPropConfig;
import ai.exaleap.gateway.config.RedisClient;
import ai.exaleap.gateway.enums.DevelopLevelEnum;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import ai.exaleap.common.enums.HttpStatusEnum;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class TokenFilter extends ZuulFilter {



    @Autowired
    AuthPropConfig authsPropConfig;

    @Autowired
    RedisClient redisClient;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;//int值来定义过滤器的执行顺序，数值越小优先级越高
    }

    /**
     * 判断是否需要进行过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        //step1. 先判断当前环境是否需要进行token 检测。

        //FIXME: 正式环境过滤 ， 测试先用local
        if(authsPropConfig.getAuthLevel().equals(DevelopLevelEnum.LOCAL.getValue())){
            log.info("\n  TokenFilter 请求地址： {}       当前环境： {} " , request.getServletPath() , DevelopLevelEnum.LOCAL.getValue() );
            return true;
        }else if(authsPropConfig.getAuthLevel().equals(DevelopLevelEnum.TEST.getValue())) {
            return false;
        }
        return false;
    }

    /**
     * 网关运行
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();


        // step1. 排除不进行token 检测的url 列表
        if(authsPropConfig.getExcludeUrls() != null ){
            for(String url : authsPropConfig.getExcludeUrls()){
                if( request.getServletPath().startsWith(url)){
                    log.info("\nTokenFilter {} 地址不过滤      {} " ,url,  request.getServletPath()  );
                    return null;
                }
            }
        }

        //step2.判断请求路径长度是否合规，是否获取到配置文件中存储的路径数据
        if(request.getServletPath().length()<=2 || authsPropConfig.getApiUrlMap().size()==0){
            return null;
        }

        //step3. 找到微服务的名称
        String serverName = request.getServletPath().substring(1 , request.getServletPath().indexOf('/' , 1));

        log.info("\n  TokenFilter {}       {} " , request.getServletPath() , serverName);

        for(String key:  authsPropConfig.getApiUrlMap().keySet()){
            log.debug("======== ApiUrlMap() 调试用    {} ",key );
        }


        if(authsPropConfig.getApiUrlMap().containsKey(serverName)){
            //step4. 检查访问对应微服务的用户权限。
            authToken(ctx, authsPropConfig.getApiUrlMap().get(serverName));
            return null;
        }else {
            //step5.如果不在白名单中， 拒绝访问
            log.info("requestPath {}  请求被拒绝， 不允许直接访问底层方法   ",  request.getServletPath() );
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatusEnum.FORBIDDEN.code());
            return null;
        }

    }





    private Object authToken( RequestContext ctx , int authUserType ){
        HttpServletRequest request = ctx.getRequest();

        //FIXME:   token  需要放到common 包中， 做成常量
        String accessToken =  request.getHeader("token");

        //如果header 中没有取到token  , 从token中尝试取一下。
        if(StringUtils.isEmpty(accessToken)) {
            accessToken =  request.getParameter("token");
        }

        //获取token
        String storeTokenValue = null;
        if(!StringUtils.isEmpty(accessToken)){
            storeTokenValue =  redisClient.get(accessToken);
        }
        //判断是否获取到token
        if( StringUtils.isEmpty(accessToken) ){
            log.info("requestPath {} ------------ 请求不带有token ",  request.getServletPath() );
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatusEnum.UNAUTHORIZED.code());
            return null;
        }
        //判断是否获取到token中的值
        if( StringUtils.isEmpty(storeTokenValue)){
            log.info("requestPath {} ------------  token 不合法 ",  request.getServletPath() );
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatusEnum.UNAUTHORIZED.code());
            return null;
        }


        JSONObject tokenObject = JSON.parseObject(storeTokenValue);
        //FIXME:   userType  需要放到common 包中， 用枚举对象
        if(tokenObject == null || tokenObject.get("userType") == null) {
            log.info("requestPath {} ------------  token 值不正确 ",  request.getServletPath() );
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatusEnum.UNAUTHORIZED.code());
        }

        int userType = (int)tokenObject.get("userType");

        //如果当前的用户type  与他访问的服务要求的用户类型不一致， 不可以访问。
        if(userType!= authUserType){
            log.info("requestPath {} ------------  token  用户类型不正确",  request.getServletPath() );
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatusEnum.UNAUTHORIZED.code());
        }


        return  null;
    }

}
