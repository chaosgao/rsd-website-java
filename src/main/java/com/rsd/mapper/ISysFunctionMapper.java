package com.rsd.mapper;

import com.rsd.bean.SysFunction;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ISysFunctionMapper {

    @Select("select * from bu_sys_function")
    List<SysFunction> queryList();

    @Select("select * from bu_sys_function where id = #{id}")
    SysFunction getById(Integer id);

    @Delete("delete from bu_sys_function where id = #{id}")
    void deleteById(Integer id);

    @Update("update bu_sys_function set name=#{name},url=#{url} where id=#{id} ")
    void update(SysFunction sysFunction);

    @Insert("insert into bu_sys_function values(null,#{name},#{url})")
    void insert(SysFunction sysFunction);
}
