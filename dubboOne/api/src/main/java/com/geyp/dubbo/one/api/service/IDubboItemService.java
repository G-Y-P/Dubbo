package com.geyp.dubbo.one.api.service;

import com.geyp.dubbo.one.api.response.BaseResponse;

/**
 * @author GEYP
 * @version 1.0
 * @date 2020/3/28 0028 15:40
 * @description
 */
public interface IDubboItemService {
    BaseResponse listItems();

    BaseResponse listPageItems(Integer pageNo,Integer pageSize);
}
