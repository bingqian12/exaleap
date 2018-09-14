package com.jzg.svsp.gateway.filter;

import com.jzg.svsp.common.enums.HttpStatusEnum;
import com.jzg.svsp.gateway.config.AuthPropConfig;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class TokenFilter extends ZuulFilter {

    private static final Logger LOG = LoggerFactory.getLogger(TokenFilter.class);

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

        if(authUrlListConfig.getUrls() == null || authUrlListConfig.getUrls().size() ==0 ){
            return null;
        }



        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
//        request.getMethod(),request.getRequestURL().toString()
        LOG.info("send {} request to {}  ",  request.getServletPath());
        String accessToken = String.valueOf(request.getParameter("token"));

        String requestPath =  request.getServletPath() ;
        for(String url : authUrlListConfig.getUrls()){

            if(requestPath.startsWith(url)  && !accessToken.equals("111")){
                LOG.info("requestPath {} ------------ authUrl {}  ",  request.getServletPath() , url);
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(HttpStatusEnum.UNAUTHORIZED.code());
                //ctx.setResponseBody(HttpStatusEnum.UNAUTHORIZED.reasonPhraseUS());
                return null;
            }
        }

        return null;
    }
}
