package com.jzg.svsp.gateway.filter;

import com.jzg.svsp.common.enums.HttpStatusEnum;
import com.jzg.svsp.gateway.config.AuthPropConfig;
import com.jzg.svsp.gateway.config.RedisClient;
import com.jzg.svsp.gateway.enums.DevelopLevelEnum;
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
    AuthPropConfig authPropConfig;

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

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        //不同环境， 权限控制的范围不同
        log.info(" authPropConfig.getAuthLevel()    {}   ", authPropConfig.getAuthLevel() );
        if(authPropConfig.getAuthLevel().equals(DevelopLevelEnum.PROD.getValue())){
            return authProd();
        }else {
            return authDev();
        }

    }


    private Object authProd(){
        log.info("authUrlListConfig.getExcludeUrls()  size  {}  ",  authPropConfig.getExcludeUrls().size());
        if(authPropConfig.getExcludeUrls() == null || authPropConfig.getExcludeUrls().size() ==0 ){
            return null;
        }
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        for(String url : authPropConfig.getExcludeUrls()){
            if(request.getServletPath().startsWith(url)){
                return null;
            }
        }

        String accessToken =  request.getHeader("token");

        if(StringUtils.isEmpty(accessToken)) {
            //如果header 中没有取到token  , 从token中尝试取一下。
            accessToken =  request.getParameter("token");
        }

        String storeTokenValue = null;
        if(!StringUtils.isEmpty(accessToken)){
            storeTokenValue =  redisClient.get(accessToken);
        }
        if( StringUtils.isEmpty(accessToken) || StringUtils.isEmpty(storeTokenValue) ){
            log.info("requestPath {} ------------  ",  request.getServletPath() );
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatusEnum.UNAUTHORIZED.code());
            return null;
        }


        return  null;

    }


    private Object authDev(){
        log.info("authUrlListConfig.getApiUrls()  size  {}  ",  authPropConfig.getApiUrls().size());
        if(authPropConfig.getApiUrls() == null || authPropConfig.getApiUrls().size() ==0 ){
            return null;
        }



        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
//        request.getMethod(),request.getRequestURL().toString()
        log.info("send {} request to {}  ",  request.getServletPath());



        String accessToken =  request.getHeader("token");

        if(StringUtils.isEmpty(accessToken)) {
            //如果header 中没有取到token  , 从token中尝试取一下。
            accessToken =  request.getParameter("token");
        }

        String storeTokenValue = null;
        if(!StringUtils.isEmpty(accessToken)){
            storeTokenValue =  redisClient.get(accessToken);
        }
        log.info("accessToken ：{}   store value： {}  ",  accessToken , storeTokenValue );
        for(String url : authPropConfig.getApiUrls()){

            if(request.getServletPath().startsWith(url)  && (StringUtils.isEmpty(accessToken) || StringUtils.isEmpty(storeTokenValue)) ){
                log.info("requestPath {} ------------ authUrl {}  ",  request.getServletPath() , url);
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(HttpStatusEnum.UNAUTHORIZED.code());
                return null;
            }
        }

        return null;

    }

}
