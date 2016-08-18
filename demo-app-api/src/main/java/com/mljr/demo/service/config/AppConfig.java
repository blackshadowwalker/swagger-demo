package com.mljr.demo.service.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;

/**
 * Created by ASUS on 2016/8/18.
 */
@Configuration
public class AppConfig implements EmbeddedServletContainerCustomizer {

    public void customize(ConfigurableEmbeddedServletContainer container) {
//        container.setPort(8082);
//        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
    }

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Bean
    Filter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

}
