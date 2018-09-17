package com.jzg.svsp.gateway.filter;

import com.jzg.svsp.common.enums.HttpStatusEnum;
import com.jzg.svsp.common.util.CookieUtil;
import com.jzg.svsp.gateway.config.AuthPropConfig;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import springfox.documentation.service.TokenEndpoint;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author JZG
 * 对监控器  dashboard 页面的权限控制。
 * 通过ip地址白名单进行过滤
 */
@Component
@Slf4j
public class MonitorFilter extends ZuulFilter {

    @Autowired
    AuthPropConfig authUrlListConfig;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        if(authUrlListConfig.getMonitorUrls() == null || authUrlListConfig.getMonitorUrls().size() ==0 ){
            return null;
        }


        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        /**
         * 检测IP地址是否在白名单
         */

        for(String url : authUrlListConfig.getMonitorUrls()){
            if(request.getServletPath().startsWith(url)  && !authUrlListConfig.getAccessIp().equals(request.getRemoteAddr())){
                log.warn("requestPath no permission '{}'  ----- AccessIP: {}  ",  request.getServletPath() , authUrlListConfig.getAccessIp());
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(HttpStatusEnum.UNAUTHORIZED.code());
                return null;
            }
        }

        return null;
    }
}
