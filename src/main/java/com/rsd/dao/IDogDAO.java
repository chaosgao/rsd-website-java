package com.rsd.dao;

import com.rsd.bean.Dog;

import java.util.List;

public interface IDogDAO {

    List<Dog> queryList();

    Dog getById(Integer id);

    void insert(Dog dog);

    void deleteById(Integer id);

    void update(Dog dog);
}
