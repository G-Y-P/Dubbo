package com.geyp.dubbo.two.server.controller;

import com.geyp.dubbo.two.server.request.RecordPushRequest;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.Map;

/**
 * @author GEYP
 * @version 1.0
 * @date 2020/3/30 0030 17:02
 * @description
 */
@RestController
public class OrderRecordController {

    private static final Logger log= LoggerFactory.getLogger(OrderRecordController.class);

    private static final String prefix="order";

    @RequestMapping(value = prefix+"/record/push",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> pushRecode(@RequestBody RecordPushRequest recordPushRequest){
        log.info("接收到请求数据"+recordPushRequest);
        Map<String,Object> map= Maps.newHashMap();
        try{
            map.put("code",0);
            map.put("msg","成功");
            //TODO:处理用户下单



        }catch (Exception e){
            log.error("用户下单失败"+e.fillInStackTrace());
            map.put("code",-1);
            map.put("msg","下单失败");
        }
        return map;
    }


}
