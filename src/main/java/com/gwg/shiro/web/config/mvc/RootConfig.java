package com.gwg.shiro.web.config.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Spring的容器
 */
@Configuration
@Order(Integer.MIN_VALUE)
@ComponentScan(basePackages={"com.gwg"}, excludeFilters={
        @ComponentScan.Filter(type= FilterType.ANNOTATION, value=EnableWebMvc.class),
        @ComponentScan.Filter(type= FilterType.ANNOTATION, value=RestController.class)//排除SpringMVC的
})
public class RootConfig {

}