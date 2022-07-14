package com.rsd.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysUser implements Serializable {

    private Integer id;

    private String loginName;

    private String password;

    private String realName;

    private Integer roleId;

    private String roleName;

    private String sex;

    private String tel;

    private Date createTime;

}
