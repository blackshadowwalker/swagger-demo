package com.mljr.demo.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Created by ASUS on 2016/8/18.
 */
@Profile({"local", "dev" })
@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class SwaggerConfig {

    @Value("${app.name}")
    String appName;
    @Value("${app.version}")
    String appVersion;

    @Bean
    public Docket swaggerSpringfoxDocket() {
        Docket swaggerSpringMvcPlugin = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName(appName)
                .consumes(Collections.singleton(MediaType.APPLICATION_FORM_URLENCODED_VALUE))//默认输入
                .produces(Collections.singleton(MediaType.APPLICATION_JSON_UTF8_VALUE))//默认输出
                .genericModelSubstitutes(ResponseEntity.class)
                .select()
                .paths(PathSelectors.regex(".*")) // and by paths
                .build();
        return swaggerSpringMvcPlugin;
    }

    private ApiInfo apiInfo(){
        ApiInfo apiInfo = new ApiInfo(
                appName ,
                "",
                appVersion,
                "http://api.demo.mljr.com",
                new Contact("LI JIAN","", "jian.li02@mljr.com"),
                "License",
                "/License");
        return apiInfo;
    }

    @Bean
    UiConfiguration uiConfig() {
        return new UiConfiguration(
                "validatorUrl",// url
                "none",       // docExpansion          => none | list
                "alpha",      // apiSorter             => alpha
                "schema",     // defaultModelRendering => schema
                UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS,
                true,        // enableJsonEditor      => true | false
                true);        // showRequestHeaders    => true | false
    }

}
