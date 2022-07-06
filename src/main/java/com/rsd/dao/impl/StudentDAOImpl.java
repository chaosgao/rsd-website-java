package com.rsd.dao.impl;

import com.rsd.bean.Student;
import com.rsd.dao.IStudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDAOImpl implements IStudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Student> mapper = new RowMapper<Student>() {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();

            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setSex(rs.getString("sex"));
            student.setAge(rs.getInt("age"));
            student.setCreateTime(rs.getTimestamp("create_time"));

            return student;
        }
    };

    @Override
    public List<Student> queryList() {
        String sql = "select * from bu_student order by id desc ";

        List<Student> list = jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override
    public Student getById(Integer id) {
        String sql = "select * from bu_student where id = ?";
        Student student = jdbcTemplate.queryForObject(sql, mapper, id);

        return student;
    }

    @Override
    public void insert(Student student) {
        String sql = "insert into bu_student values(null, ? , ? , ? , ?)";
        jdbcTemplate.update(sql, student.getName(), student.getSex(), student.getAge(), student.getCreateTime());
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "delete from bu_student where id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void update(Student student) {
        String sql = "update bu_student set name= ?,sex= ?,age= ? where id = ?";
        jdbcTemplate.update(sql,student.getName(),student.getSex(),student.getAge(),student.getId());
    }
}
