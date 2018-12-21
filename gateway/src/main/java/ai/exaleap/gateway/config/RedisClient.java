package ai.exaleap.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 13:49 on 2018/9/14.
 */
@Component("redisClient")
@Slf4j
public class RedisClient {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public boolean set(String key, String value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            log.error("RedisClient>set异常", e);
        }
        return result;
    }

    public boolean set(String key, String value, long time) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            log.error("RedisClient>set异常", e);
        }
        return result;

    }


    public String get(String key) {
        String result = null;
        try {
            result = redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            log.error("RedisClient>get异常", e);
        }
        return result;
    }

}
