package com.jzg.svsp.customer.service;

import com.jzg.svsp.common.vo.ResultVo;

/**
 * @Author: jzg
 * @Description:
 * @Date: Created by 10:57 on 2018/9/14.
 */
public interface ISmsService {

    ResultVo sendValidateCode(String mobile);



}
