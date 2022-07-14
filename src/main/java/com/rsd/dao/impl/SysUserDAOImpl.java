package com.rsd.dao.impl;

import com.rsd.bean.SysUser;
import com.rsd.dao.ISysUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SysUserDAOImpl implements ISysUserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<SysUser> mapper = new RowMapper<SysUser>() {
        @Override
        public SysUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            SysUser sysUser = new SysUser();
            sysUser.setId(rs.getInt("id"));
            sysUser.setLoginName(rs.getString("login_name"));
            sysUser.setPassword(rs.getString("password"));
            sysUser.setRealName(rs.getString("real_name"));
            sysUser.setRoleId(rs.getInt("role_id"));
            sysUser.setRoleName(rs.getString("role_name"));
            sysUser.setSex(rs.getString("sex"));
            sysUser.setTel(rs.getString("tel"));
            sysUser.setCreateTime(rs.getTimestamp("create_time"));
            return sysUser;
        }
    };

    @Override
    public List<SysUser> queryList() {
        String sql = "select b1.*,b2.name role_name from bu_sys_user b1 left join bu_sys_role b2 on b1.role_id=b2.id order by id desc";
        return jdbcTemplate.query(sql,mapper);
    }
}
