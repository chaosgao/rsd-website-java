package com.rsd.dao.impl;

import com.rsd.bean.Message;
import com.rsd.dao.IMessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class MessageImpl implements IMessageDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Message> mapper = new RowMapper<Message>() {
        @Override
        public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
            Message message = new Message();
            message.setId(rs.getInt("id"));
            message.setContent(rs.getString("content"));
            message.setCause(rs.getString("cause"));
            return message;
        }
    };


    @Override
    public List<Message> queryList() {
        String sql = "select * from bu_message";
        return jdbcTemplate.query(sql,mapper);
    }

    @Override
    public void insert(Message message) {
        String sql = "insert into bu_message values (null ,?,?)";
        jdbcTemplate.update(sql,message.getContent(),message.getCause());
    }
}
