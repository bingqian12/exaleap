package com.jzg.svsp.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AuthUrlListConfigTest {

    @Autowired
    AuthPropConfig authUrlListConfig;

    @Test
    public void getAuthUrlList() {
       List<String> urls =  authUrlListConfig.getUrls();

       log.info("\n============================== urls {}" ,  urls.size());
        log.info("\n============================== testurl {}" ,  authUrlListConfig.getTesturl());
        Assert.assertTrue(urls.size()>0);

    }
}