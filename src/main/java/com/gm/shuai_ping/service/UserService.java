package com.gm.shuai_ping.service;

import com.gm.shuai_ping.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(Integer id);
    public int insertUser(User user);
    public int deleteUserById(Integer id);
    public int updateUser(User user);
}
