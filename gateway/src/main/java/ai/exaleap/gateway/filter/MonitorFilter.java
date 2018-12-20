package ai.exaleap.gateway.filter;

import com.jzg.svsp.gateway.config.AuthPropConfig;
import com.netflix.zuul.ZuulFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @Autowired
    AuthPropConfig authUrlMapConfig;

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



        return null;
    }
}
