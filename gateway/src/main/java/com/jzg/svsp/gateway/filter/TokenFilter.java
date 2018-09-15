package com.jzg.svsp.gateway.filter;

import com.jzg.svsp.common.enums.HttpStatusEnum;
import com.jzg.svsp.gateway.config.AuthPropConfig;
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
    AuthPropConfig authUrlListConfig;

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

        if(authUrlListConfig.getApiUrls() == null || authUrlListConfig.getApiUrls().size() ==0 ){
            return null;
        }



        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
//        request.getMethod(),request.getRequestURL().toString()
        log.info("send {} request to {}  ",  request.getServletPath());
        String accessToken = String.valueOf(request.getParameter("token"));


        for(String url : authUrlListConfig.getApiUrls()){

            if(request.getServletPath().startsWith(url)  && (StringUtils.isEmpty(accessToken) || !"111".equals(accessToken))){
                log.info("requestPath {} ------------ authUrl {}  ",  request.getServletPath() , url);
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(HttpStatusEnum.UNAUTHORIZED.code());
                return null;
            }
        }

        return null;
    }
}
