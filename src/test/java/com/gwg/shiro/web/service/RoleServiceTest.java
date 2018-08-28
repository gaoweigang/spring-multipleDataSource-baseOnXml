package com.gwg.shiro.web.service;

import com.alibaba.fastjson.JSON;
import com.gwg.shiro.web.dto.RoleDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.model.Role;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RoleServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(RoleServiceTest.class);

    private RoleService roleService;

    /**
     * 每个测试方法执行之前执行一次
     */
    @Before
    public void before(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        roleService = applicationContext.getBean(RoleService.class);
    }


    @Test
    public void testAddRole() throws BusinessException {
        RoleDto dto = new RoleDto();
        dto.setRoleCode("test");
        dto.setRoleName("测试");
        dto.setRemark("测试");
        boolean flag = roleService.addRole(dto);
        logger.info("添加角色，参数：{}, 结果：{}", JSON.toJSON(dto), JSON.toJSON(flag));

    }

    @Test
    public void testQueryRoleById() throws BusinessException{
        RoleDto dto = new RoleDto();
        dto.setId(1L);
        Role role = roleService.queryRoleById(dto);
        logger.info("根据id查询，参数：{}, 结果：{}", JSON.toJSON(dto), JSON.toJSON(role));


    }




}
