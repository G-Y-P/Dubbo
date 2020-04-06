package com.geyp.dubbo.one.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author GEYP
 * @version 1.0
 * @date 2020/3/27 0027 14:14
 * @description
 */
@SpringBootApplication
@ImportResource(value={"classpath:spring/spring-jdbc.xml","classpath:spring/spring-dubbo.xml"})
@MapperScan(basePackages = "com.geyp.dubbo.one.model.mapper")
@EnableScheduling
public class BootMoreApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(BootMoreApplication.class);
    }

    public static void main(String[] ages)throws Exception{
        SpringApplication.run(BootMoreApplication.class,ages);
    }
}
