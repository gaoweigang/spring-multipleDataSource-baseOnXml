package com.gwg.shiro.web.service;

import com.alibaba.fastjson.JSON;
import com.gwg.shiro.web.dto.UserDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("/spring-config.xml")
public class UserServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    private UserService userService;

    /**
     * 每个测试方法执行之前执行一次
     */
    @Before
    public void before(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        userService = applicationContext.getBean(UserService.class);
    }


    @Test
    public void testAddUser() throws BusinessException {

        UserDto dto = new UserDto();
        dto.setUserId("13817191490");
        dto.setUsername("高伟刚");
        dto.setCardNo("420881199101095174");
        dto.setEmail("13817191469@163.com");
        dto.setEntryTime(new Date());
        dto.setMobile("13817191469");
        boolean flag = userService.addUser(dto);

        logger.info(" 参数：{}， 结果：{}", JSON.toJSON(dto), flag );
    }



    @Test
    public void testQueryUserInfoById() throws BusinessException{
        UserDto dto = new UserDto();
        dto.setId(22L);
        User user = userService.queryUserInfoById(dto);
        logger.info(" 参数：{}， 结果：{}", JSON.toJSON(dto), user );

    }
}
