package com.jzg.svsp.common.swagger;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wang.linqiao
 * @creation: 2018/11/1 19:44
 * @notes:
 */
@Component
public class SwaggerParamConfig {
    @Value("${swagger.header:''}")
    private String params;

    private static final List<String> list = Lists.newArrayList();

    @PostConstruct
    private void loadParam() {
        if (StringUtils.isNotBlank(params)) {
            Arrays.stream(params.split(",")).forEach(list::add);
        }
    }

    public static List<String> getParams() {
        return list;
    }

    public static boolean hasParam() {
        return !CollectionUtils.isEmpty(list);
    }

}
