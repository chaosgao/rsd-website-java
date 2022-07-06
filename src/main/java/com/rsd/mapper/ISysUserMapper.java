package com.rsd.mapper;

import com.rsd.bean.SysUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ISysUserMapper {

    @Select("select b1.*,b2.name role_name from bu_sys_user b1 left join bu_sys_role b2 on b1.role_id=b2.id order by id desc")
    List<SysUser> queryList();

    @Select("select * from bu_sys_user where id = #{id}")
    SysUser getById(Integer id);

    @Delete("delete from bu_sys_user where id = #{id}")
    void deleteById(Integer id);

    @Update("update bu_sys_user set login_name=#{loginName},password=#{password},real_name=#{realName},role_id=#{roleId},sex=#{sex},tel=#{tel},create_time=#{createTime} where id = #{id}")
    void update(SysUser sysUser);

    @Insert("insert into bu_sys_user values(null,#{loginName},#{password},#{realName},#{roleId},#{sex},#{tel},#{createTime})")
    void insert(SysUser sysUser);
}
