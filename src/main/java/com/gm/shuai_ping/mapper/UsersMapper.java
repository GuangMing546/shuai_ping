package com.gm.shuai_ping.mapper;

import com.gm.shuai_ping.entity.User;
import java.util.List;

public interface UsersMapper {
    List<User> selectAll();
    User selectUserById(Integer id);
    int insertUser(User user);
    int deleteUserById(Integer id);
    int updateUser(User user);
}