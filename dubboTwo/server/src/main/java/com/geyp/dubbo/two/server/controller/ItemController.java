package com.geyp.dubbo.two.server.controller;

import com.geyp.dubbo.one.api.response.BaseResponse;
import com.geyp.dubbo.one.api.service.IDubboItemService;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author GEYP
 * @version 1.0
 * @date 2020/3/29 0029 10:43
 * @description
 */
@RestController
public class ItemController {
    private static final Logger log= LoggerFactory.getLogger(ItemController.class);

    private static  final String prefix="item";

    @Autowired
    private IDubboItemService dubboItemService;

    /**
     * 用户商品列表查询
     * @return
     */
    @RequestMapping(value = prefix+"/list",method = RequestMethod.GET)
    public Map<String,Object> list(){
        Map<String,Object> map= Maps.newHashMap();
        try{
            BaseResponse response = dubboItemService.listItems();
            if (response!=null && response.getCode().equals(1)){
                map.put("data",response.getData());
            }

            map.put("code","0");
            map.put("msg","成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","失败");
        }
        return map;
    }

    /**
     * 用户商品列表分页查询
     * @return
     */
    @RequestMapping(value = prefix+"/pagelist",method = RequestMethod.GET)
    public Map<String,Object> pagelist(Integer pageNo,Integer pageSize){
        if(pageNo==null||pageSize==null||pageNo<=0||pageSize<=0){
            pageNo=1;
            pageSize=2;
        }

        Map<String,Object> map= Maps.newHashMap();
        try{
            BaseResponse response = dubboItemService.listPageItems(pageNo,pageSize);
            if (response!=null && response.getCode().equals(1)){
                map.put("data",response.getData());
            }

            map.put("code","0");
            map.put("msg","成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","失败");
        }
        return map;
    }
}
