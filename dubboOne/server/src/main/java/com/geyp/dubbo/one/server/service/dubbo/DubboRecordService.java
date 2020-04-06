package com.geyp.dubbo.one.server.service.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.geyp.dubbo.one.api.enums.StatusCode;
import com.geyp.dubbo.one.api.response.BaseResponse;
import com.geyp.dubbo.one.api.response.PushOrderDto;
import com.geyp.dubbo.one.api.service.IDubboRecordService;
import com.geyp.dubbo.one.model.entity.ItemInfo;
import com.geyp.dubbo.one.model.entity.OrderRecord;
import com.geyp.dubbo.one.model.mapper.ItemInfoMapper;
import com.geyp.dubbo.one.model.mapper.OrderRecordMapper;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Date;

/**
 * @author GEYP
 * @version 1.0
 * @date 2020/3/29 0029 20:54
 * @description
 */
@Service(protocol = {"dubbo","rest"},validation = "true",version = "1.0",timeout = 3000)
@Path("/record")
public class DubboRecordService implements IDubboRecordService {

    private static final Logger log= LoggerFactory.getLogger(DubboRecordService.class);

    @Autowired
    private ItemInfoMapper itemInfoMapper;

    @Autowired
    private OrderRecordMapper orderRecordMapper;
    @Override
    @Path("/push")
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON_VALUE)
    @Produces(value = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse pushOrder(PushOrderDto dto){
        if(dto.getItemId()==null||dto.getItemId()<=0|| Strings.isNullOrEmpty(dto.getCustomerName())
        ||dto.getTotal()==null){
            return new BaseResponse(StatusCode.Fail);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try{
            //业务逻辑
            //TODO:校验商品是否存在
            ItemInfo info=itemInfoMapper.selectByPrimaryKey(dto.getItemId());
            if(info==null){
                return new BaseResponse(StatusCode.ItemNotExist);
            }
            //TODO：库存。。。
            //TODO：客户中心服务。。。

            //TODO：订单服务。。。
            OrderRecord orderRecord=new OrderRecord();
            BeanUtils.copyProperties(dto,orderRecord);
            orderRecord.setOrderTime(new Date());
            orderRecordMapper.insert(orderRecord);
            response.setData(orderRecord.getId());
        }catch (Exception e){
            e.printStackTrace();
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }
}
