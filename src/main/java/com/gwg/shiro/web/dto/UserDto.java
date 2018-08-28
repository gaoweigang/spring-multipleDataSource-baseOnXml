package com.gwg.shiro.web.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;


@Data
public class UserDto {

    private Long id;

    //用户名
    private String userId;

    //姓名
    private String username;

    //性别
    private Integer sex;

    //出生日期
    private Date birthday;

    //邮件
    private String email;

    //身份证号
    private String cardNo;

    //手机号码
    private String mobile;

    //入职时间
    private Date entryTime;


    //当前登录用户名
    private String creator;

    //页数
    private int pageIndex;

    //每页显示条数
    private int pageSize;

    //排序
    private String sort;

}
