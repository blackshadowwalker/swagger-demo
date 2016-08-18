package com.mljr.demo.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by ASUS on 2016/8/18.
 */
@Configuration
@PropertySource({"classpath:env/app.properties", "classpath:db.properties", "classpath:redis.properties"})
@ImportResource({"classpath:spring-service.xml"})
public class ServiceConfig {

}
