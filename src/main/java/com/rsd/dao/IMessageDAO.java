package com.rsd.dao;

import com.rsd.bean.Message;

import java.util.List;

public interface IMessageDAO {

    List<Message> queryList();

    void insert(Message message);
}
