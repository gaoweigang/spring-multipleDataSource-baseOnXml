package com.gwg.shiro.web.controller;

import com.gwg.shiro.web.common.Result;
import com.gwg.shiro.web.common.ReturnCode;
import com.gwg.shiro.web.dto.UserDto;
import com.gwg.shiro.web.model.User;
import com.gwg.shiro.web.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "user", tags = "用户管理")
public class UserController {

    private UserService userService;

    @ApiOperation(value = "添加用户")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public @ResponseBody Result addUser(UserDto dto){
        userService.addUser(dto);
        return new Result(true, ReturnCode.SUCCESS.getMessage(), null , ReturnCode.SUCCESS.getCode());
    }

    @ApiOperation(value = "根据ID查询用户")
    @RequestMapping(value = "/queryUserInfoById", method = RequestMethod.POST)
    public @ResponseBody Result queryUserInfoById(UserDto dto){
        User user = userService.queryUserInfoById(dto);
        return new Result(true, ReturnCode.SUCCESS.getMessage(), user , ReturnCode.SUCCESS.getCode());
    }


}
