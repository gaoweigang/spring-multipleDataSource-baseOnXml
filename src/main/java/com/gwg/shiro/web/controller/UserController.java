package com.gwg.shiro.web.controller;

import com.gwg.shiro.web.common.Result;
import com.gwg.shiro.web.dto.UserDto;
import com.gwg.shiro.web.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;


    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public @ResponseBody Result addUser(UserDto dto){
        userService.addUser(dto);
        return new Result(true, null, null, null);
    }




}
