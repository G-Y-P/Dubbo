package com.geyp.dubbo.one.api.service;

import com.geyp.dubbo.one.api.response.BaseResponse;
import com.geyp.dubbo.one.api.response.PushOrderDto;

/**
 * @author GEYP
 * @version 1.0
 * @date 2020/3/29 0029 20:50
 * @description
 */
public interface IDubboRecordService {

    public BaseResponse pushOrder(PushOrderDto dto);
}
