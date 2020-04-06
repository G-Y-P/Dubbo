package com.geyp.dubbo.two.server.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.geyp.dubbo.two.server.request.RecordPushRequest;
import okhttp3.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author GEYP
 * @version 1.0
 * @date 2020/3/30 0030 17:23
 * @description
 */
@Service
public class OrderRecordService {
    private static final Logger log= LoggerFactory.getLogger(OrderRecordService.class);

    private static final String url="http://localhost:9012/v1/record/push";

    private OkHttpClient httpClient=new OkHttpClient();

    @Autowired
    private ObjectMapper objectMapper;
    /**
     * 处理用户下单数据,发起HTTP请求
     *
     */
    public void pushOrder(RecordPushRequest recordPushRequest)throws Exception{
        try{
            //TODO:构造builder
            Request.Builder builder=new Request.Builder()
                    .url(url)
                    .header("Content-Type","application/json");
            //TODO：构造请求体
            RequestBody requestBody=RequestBody.create(MediaType.parse("application/json"),
                    objectMapper.writeValueAsString(recordPushRequest));
            //TODO：构造请求
            Request request=builder.post(requestBody).build();

            //TODO：发起请求

            Response response = httpClient.newCall(request).execute();

            log.info(response.body().toString());
        }catch (Exception e){
            throw e;
        }





    }
}
