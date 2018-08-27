package com.gwg.shiro.web.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author
 *
 */
@Data
public class RoleDto implements Serializable{

    private Long id;

    private String roleCode;

    private String roleName;

    /**
     * 描述
     */
    private String remark;

    /**
     * 当前登录用户id
     */
    private String creator;


    private List<Long> resourceIdList;


    //页数
    private int pageIndex;

    //每页显示条数
    private int pageSize;

    //排序
    private String sort;
}
