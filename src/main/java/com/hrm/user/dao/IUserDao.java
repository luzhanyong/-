package com.hrm.user.dao;

import com.hrm.commons.benas.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IUserDao {
    User selectUserByLoginUser(User user);

    List<User> selectUser(Map map);

    Integer selectUserCount(User user);

    User selectUserById(Integer id);

    int updateUser(User user);

    int insertUser(User user);

    int deleteUser(@Param("ids") Integer[] ids);
}
