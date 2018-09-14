package com.jzg.svsp.customer.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jzg.svsp.common.enums.SmsTemplateCode;
import com.jzg.svsp.common.util.HttpUtils;
import com.jzg.svsp.common.util.RandomUtils;
import com.jzg.svsp.common.util.SignUtils;
import com.jzg.svsp.common.vo.Constants;
import com.jzg.svsp.common.vo.ResultVo;
import com.jzg.svsp.common.vo.RetStatus;
import com.jzg.svsp.customer.config.RedisClient;
import com.jzg.svsp.customer.service.ISmsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 10:58 on 2018/9/14.
 */
@Service(value = "smsService")
@Slf4j
public class SmsService implements ISmsService {

    @Value("${sms.url}")
    private String smsUrl;

    @Value("${sms.appId}")
    private String appId;

    @Value("${sms.appKey}")
    private String appKey;

    @Autowired
    private RedisClient redisClient;

    @Override
    public ResultVo sendValidateCode(String mobile) {
        String validateCode = RandomUtils.getValidateCode();
        redisClient.set(Constants.VALIDATE_CODE_PREFIX + mobile, validateCode, Constants.VALIDATE_CODE_EFFECTIVE_TIME);//向redis里存入数据和设置缓存时间
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("appId", appId);
        paramMap.put("templateCode", SmsTemplateCode.ValidateCodeTpl.getValue());
        JSONObject jsonPara = new JSONObject();
        jsonPara.put("code", validateCode);
        paramMap.put("jsonPara", jsonPara.toJSONString());
        paramMap.put("phoneNumber", mobile);
        return sendMsg(paramMap);
    }



    private ResultVo sendMsg(Map<String, Object> paramMap) {
        ResultVo resultVo = new ResultVo();
        try {
            String sign = SignUtils.generateSign(paramMap, appKey);

            paramMap.put("sign", sign);
            String responsestr = HttpUtils.doPost(smsUrl, paramMap);

            if (StringUtils.isNotBlank(responsestr)) {
                resultVo = JSONObject.parseObject(responsestr, ResultVo.class);
                if (RetStatus.Ok.getValue() == resultVo.getStatus()) {
                    resultVo.setStatus(RetStatus.Ok.getValue());
                    resultVo.setMsg("发送成功");
                } else {
                    log.error("短信发送失败" +
                            ",paramMap=" + JSONObject.toJSONString(paramMap) + ",responsestr=" + responsestr);
                    resultVo.setStatus(RetStatus.Failure.getValue());
                    resultVo.setMsg("短信发送失败");
                }
            } else {
                log.error("短信发送失败" +
                        ",paramMap=" + JSONObject.toJSONString(paramMap) + ",responsestr=" + responsestr);
                resultVo.setStatus(RetStatus.Failure.getValue());
                resultVo.setMsg("短信发送失败");
            }
        } catch (Exception e) {
            log.error("短信发送发生异常" +
                    ",paramMap=" + JSONObject.toJSONString(paramMap));
            log.error("调用短信发送发生异常." + e.getMessage(), e);
            resultVo.setStatus(RetStatus.Exception.getValue());
            resultVo.setMsg("短信发送发生异常." + e.getMessage());
        }

        return resultVo;
    }
}
