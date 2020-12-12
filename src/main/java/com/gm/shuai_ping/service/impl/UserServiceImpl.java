package com.gm.shuai_ping.service.impl;

import com.gm.shuai_ping.entity.User;
import com.gm.shuai_ping.mapper.UsersMapper;
import com.gm.shuai_ping.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UsersMapper usersMapper;

    @Override
    public List<User> getAllUsers() {
        return usersMapper.selectAll();
    }

    @Override
    public User getUserById(Integer id) {
        return usersMapper.selectUserById(id);
    }

    @Override
    public int insertUser(User user) {
        return usersMapper.insertUser(user);
    }

    @Override
    public int deleteUserById(Integer id) {
        return usersMapper.deleteUserById(id);
    }

    @Override
    public int updateUser(User user) {
        return usersMapper.updateUser(user);
    }
}
