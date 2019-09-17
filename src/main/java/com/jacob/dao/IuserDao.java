package com.jacob.dao;

import com.jacob.domain.User;
import com.jacob.mybatis.annotations.Select;

import java.util.List;

public interface IuserDao {
    @Select("select * from user")
    List<User> findAll();
}
