package com.geyp.dubbo.one.api.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author GEYP
 * @version 1.0
 * @date 2020/3/29 0029 20:51
 * @description
 */
@Data
@ToString
public class PushOrderDto implements Serializable {

    //商品ID
    private Integer itemId;

    //下单数量
    private Integer total;


    private String customerName;

}
