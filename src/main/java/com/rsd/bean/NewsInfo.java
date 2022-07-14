package com.rsd.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class NewsInfo implements Serializable {

    private Integer id;

    private String title;

    private Integer typeId;

    private  String shortDesc;

    private String content;

    private String showTime;

    private Integer pubUserId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    private String typeName;

    private String realName;
}
