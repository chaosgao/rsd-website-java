package com.rsd.dao.impl;

import com.rsd.bean.NewsInfo;
import com.rsd.dao.INewsInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NewsInfoDAOImpl implements INewsInfoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private RowMapper<NewsInfo> mapper = new RowMapper<NewsInfo>() {
        @Override
        public NewsInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
            NewsInfo newsInfo = new NewsInfo();

            newsInfo.setId(rs.getInt("id"));
            newsInfo.setTitle(rs.getString("title"));
            newsInfo.setTypeId(rs.getInt("type_id"));
            newsInfo.setShortDesc(rs.getString("short_desc"));
            newsInfo.setContent(rs.getString("content"));
            newsInfo.setShowTime(rs.getString("show_time"));
            newsInfo.setPubUserId(rs.getInt("pub_user_id"));
            newsInfo.setCreateTime(rs.getTimestamp("create_time"));
            newsInfo.setUpdateTime(rs.getTimestamp("update_time"));

            newsInfo.setTypeName(rs.getString("type_name"));
            newsInfo.setRealName(rs.getString("real_name"));
            return newsInfo;
        }
    };

    @Override
    public List<NewsInfo> queryList() {
        String sql = "select b1.*,b2.real_name from (select b1.*,b2.name type_name from bu_news_info b1,bu_news_type b2 where b1.type_id = b2.id)b1,bu_sys_user b2 where b1.pub_user_id = b2.id order by b1.id desc";

        List<NewsInfo> list = jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override
    public NewsInfo getById(Integer id) {
        String sql = "select b1.*,b2.real_name from (select b1.*,b2.name type_name from bu_news_info b1,bu_news_type b2 where b1.type_id = b2.id)b1 left join bu_sys_user b2 on b1.pub_user_id = b2.id where b1.id=?";
        NewsInfo newsInfo = jdbcTemplate.queryForObject(sql, mapper, id);
        return newsInfo;
    }

    @Override
    public void insert(NewsInfo newsInfo) {
        String sql = "insert into bu_news_info values(null ,?,?,?,?,?,?,?,?) ";
        jdbcTemplate.update(sql,newsInfo.getTitle(),newsInfo.getTypeId(),newsInfo.getShortDesc(),newsInfo.getContent(),newsInfo.getShowTime(),newsInfo.getPubUserId(),newsInfo.getCreateTime(),newsInfo.getUpdateTime());
    }

    @Override
    public void update(NewsInfo newsInfo) {
        String sql = "update bu_news_info set title=?,type_id=?,short_desc=?,content=?,show_time=?,pub_user_id=?,update_time=? where id = ?";
        jdbcTemplate.update(sql,newsInfo.getTitle(),newsInfo.getTypeId(),newsInfo.getShortDesc(),newsInfo.getContent(),newsInfo.getShowTime(),newsInfo.getPubUserId(),newsInfo.getUpdateTime(),newsInfo.getId());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from bu_news_info where id = ?";
        jdbcTemplate.update(sql,id);
    }
}
