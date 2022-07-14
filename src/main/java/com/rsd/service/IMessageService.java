package com.rsd.service;

import com.rsd.bean.Message;

import java.util.List;

public interface IMessageService {

    List<Message> queryList();

    void insert(Message message);
}
