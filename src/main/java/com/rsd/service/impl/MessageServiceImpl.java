package com.rsd.service.impl;

import com.rsd.bean.Message;
import com.rsd.dao.IMessageDAO;
import com.rsd.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private IMessageDAO messageDAO;


    @Override
    public List<Message> queryList() {
        return messageDAO.queryList();
    }

    @Override
    public void insert(Message message) {
        messageDAO.insert(message);
    }
}
