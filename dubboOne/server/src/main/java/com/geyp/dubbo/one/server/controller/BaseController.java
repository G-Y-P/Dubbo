package com.geyp.dubbo.one.server.controller;

import com.geyp.dubbo.one.api.enums.StatusCode;
import com.geyp.dubbo.one.api.response.BaseResponse;
import com.geyp.dubbo.one.model.entity.ItemInfo;
import com.geyp.dubbo.one.model.mapper.ItemInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;
import java.util.List;

/**
 * @author GEYP
 * @version 1.0
 * @date 2020/3/27 0027 16:37
 * @description
 */
@RestController
public class BaseController {

    /*private static  final Logger log= LoggerFactory.getLogger(BaseController.class);
    private static final String prefix="base";

    @Autowired
    private ItemInfoMapper itemInfoMapper;

    @RequestMapping(value = prefix+"/one",method = RequestMethod.GET)
    public BaseResponse one(@RequestParam String param){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try{

            List<ItemInfo> infos=itemInfoMapper.selectAll();

            response.setData(infos);
        }catch (Exception e){
            e.printStackTrace();
            response=new BaseResponse(StatusCode.Fail);

        }
        return response;
    }
*/

}
