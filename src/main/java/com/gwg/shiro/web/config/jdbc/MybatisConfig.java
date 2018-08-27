package com.gwg.shiro.web.config.jdbc;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration
public class MybatisConfig {

    private static final Logger logger = LoggerFactory.getLogger(MybatisConfig.class);

    @Bean
    @Order(Integer.MIN_VALUE)
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocation(new ClassPathResource("config.properties"));
        propertyPlaceholderConfigurer.setFileEncoding("UTF-8");
        return propertyPlaceholderConfigurer;
    }


    /**
     * 生成一个名字为 sqlSessionFactory 的bean
     * mybatis的sqlSessionFactory配置
     */
    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource dynamicDataSource) throws Exception{
        logger.info("********DynamicDataSource:{}", dynamicDataSource);
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);
        bean.setTypeAliasesPackage("com.gwg.shiro.web.model");
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources("classpath*:com/gwg/shiro/web/mapper/*.xml"));
        return bean.getObject();
    }

    /**
     * 生成一个名字为mapperScannerConfigurer的bean
     * mapper接口扫描包
     */
    @Bean
    @Order
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        configurer.setBasePackage("com.gwg.shiro.web.mapper");
        return configurer;
    }

}
