package com.geyp.dubbo.two.server.request;

import lombok.ToString;

import java.io.Serializable;

/**
 * @author GEYP
 * @version 1.0
 * @date 2020/3/30 0030 17:10
 * @description
 */
@ToString
public class RecordPushRequest implements Serializable {

    //商品ID
    private Integer itemId;
    //名称
    private Integer total;
    //
    private String customerName;

}
