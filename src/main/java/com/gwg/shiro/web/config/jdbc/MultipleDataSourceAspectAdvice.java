package com.gwg.shiro.web.config.jdbc;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 切面
 */
@Aspect // for aop
@Component // for auto scan
@Order(0) // execute before @Transactional
public class MultipleDataSourceAspectAdvice {

    @Pointcut("execution(public * com.gwg.shiro.web.mapper..insert*(..))")
    public void invanyMethod() {
    };

    @Pointcut("execution(public * com.gwg.shiro.web.mapper..query*(..))")
    public void galaxyanyMethod() {
    };

    @Before("invanyMethod()")
    public void beforeinv(JoinPoint jp) {
        Object[] args = jp.getArgs();
        if(args==null){
            DataSourceTypeManager.set(DataSourceType.MASTER.getCode());
            //return;
        }
        System.out.println("-------------" + args[0]);
        DataSourceTypeManager.set(DataSourceType.MASTER.getCode());
    }

    @Before("galaxyanyMethod()")
    public void beforegalaxy(JoinPoint jp) {
        DataSourceTypeManager.set(DataSourceType.SLAVE.getCode());
    }

}