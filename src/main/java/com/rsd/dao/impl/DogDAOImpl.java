package com.rsd.dao.impl;

import com.rsd.bean.Dog;
import com.rsd.dao.IDogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DogDAOImpl implements IDogDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Dog> mapper = new RowMapper<Dog>() {
        @Override
        public Dog mapRow(ResultSet rs, int rowNum) throws SQLException {
            Dog dog = new Dog();

            dog.setId(rs.getInt("id"));
            dog.setName(rs.getString("name"));
            dog.setSex(rs.getString("sex"));
            dog.setAge(rs.getInt("age"));
            dog.setBirthTime(rs.getTimestamp("birth_time"));

            return dog;
        }
    };

    @Override
    public List<Dog> queryList() {
        String sql = "select * from bu_dog";

        List<Dog> list = jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override
    public Dog getById(Integer id) {
        String sql = "select * from bu_dog where id = ?";
        Dog dog = jdbcTemplate.queryForObject(sql, mapper, id);

        return dog;
    }

    @Override
    public void insert(Dog dog) {
        String sql = "insert into bu_dog values(null, ? , ? , ? , ?)";
        jdbcTemplate.update(sql, dog.getName(), dog.getSex(), dog.getAge(), dog.getBirthTime());
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "delete from bu_dog where id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void update(Dog dog) {
        String sql = "update bu_dog set name= ?,sex= ?,age= ?,birth_time= ? where id = ?";
        jdbcTemplate.update(sql,dog.getName(),dog.getSex(),dog.getAge(),dog.getBirthTime(),dog.getId());
    }
}
