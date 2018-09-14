package com.jzg.svsp.gateway.filter;

import com.jzg.svsp.gateway.config.AuthPropConfig;
import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthFilter extends ZuulFilter {

    private static final Logger LOG = LoggerFactory.getLogger(AuthFilter.class);

    @Autowired
    AuthPropConfig authUrlListConfig;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;//int值来定义过滤器的执行顺序，数值越小优先级越高
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        //TODO:  未来在这里做权限验证

        return null;
    }
}
