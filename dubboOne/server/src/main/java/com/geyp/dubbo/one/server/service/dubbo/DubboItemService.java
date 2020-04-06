package com.geyp.dubbo.one.server.service.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.geyp.dubbo.one.api.enums.StatusCode;
import com.geyp.dubbo.one.api.response.BaseResponse;
import com.geyp.dubbo.one.api.service.IDubboItemService;
import com.geyp.dubbo.one.model.entity.ItemInfo;
import com.geyp.dubbo.one.model.mapper.ItemInfoMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

/**
 * @author GEYP
 * @version 1.0
 * @date 2020/3/28 0028 15:43
 * @description
 */
@Path("/moocOne")
@Service(protocol = {"dubbo","rest"},validation = "true",version = "1.0",timeout = 3000)
public class DubboItemService implements IDubboItemService {

    private static final Logger log= LoggerFactory.getLogger(DubboItemService.class);

    @Autowired
    private ItemInfoMapper itemInfoMapper;


    @Override
    @Path("/item/list")
    public BaseResponse listItems() {
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try{
            List<ItemInfo> infos=itemInfoMapper.selectAll();
            log.info("查询到的商品列表数据：{}",infos);
            response.setData(infos);
        }catch (Exception e){
            log.error("列表查询服务发生异常",e.fillInStackTrace());
            response=new BaseResponse(StatusCode.Fail);
        }
        return response;
    }

    /**
     * 商品列表分页服务
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    @Path("/item/page/list")
    public BaseResponse listPageItems(@QueryParam("pageNo") Integer pageNo,
                                      @QueryParam("pageSize") Integer pageSize) {
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try{
            PageHelper.startPage(pageNo,pageSize);
            PageInfo info=new PageInfo<ItemInfo>(itemInfoMapper.selectAll());
            log.info("查询到的商品列表分页数据：{}",info);
            response.setData(info);
        }catch (Exception e){
            log.error("列表查询服务发生异常",e.fillInStackTrace());
            response=new BaseResponse(StatusCode.Fail);
        }
        return response;
    }
}
