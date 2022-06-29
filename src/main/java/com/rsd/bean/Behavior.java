package com.rsd.bean;

import lombok.Data;

import java.util.List;

@Data
public class Behavior {

    private Integer id;

    private String name;

    private Integer fatherId;

    private List<Behavior> fatherList;
}
