package com.rsd.dao.impl;

import com.rsd.bean.Behavior;
import com.rsd.dao.IBehaviorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BehaviorImpl implements IBehaviorDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Behavior> mapper= new RowMapper<Behavior>() {
        @Override
        public Behavior mapRow(ResultSet rs, int rowNum) throws SQLException {
            Behavior behavior = new Behavior();
            behavior.setId(rs.getInt("id"));
            behavior.setName(rs.getString("name"));
            behavior.setFatherId(rs.getInt("father_id"));
            return behavior;
        }
    };

    @Override
    public List<Behavior> getByFatherId(Integer fatherId) {
        String sql = "select * from bu_behavior where father_id = "+fatherId;
        List<Behavior> list = jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override
    public List<Behavior> list() {
        String sql = "select * from bu_behavior";
        List<Behavior> list = jdbcTemplate.query(sql, mapper);
        return list;
    }
}
