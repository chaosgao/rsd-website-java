package com.rsd.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Dog {

    private Integer id;

    private String name;

    private String sex;

    private Integer age;

    private Date birthTime;

}
