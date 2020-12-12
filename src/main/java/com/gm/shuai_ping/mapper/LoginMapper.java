package com.gm.shuai_ping.mapper;

import com.gm.shuai_ping.entity.LoginEntity;
import com.gm.shuai_ping.entity.User;

public interface LoginMapper {
    public User getUserFromLogin(LoginEntity loginEntity);
}
