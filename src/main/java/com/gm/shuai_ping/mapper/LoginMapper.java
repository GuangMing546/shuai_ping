package com.gm.shuai_ping.mapper;

import com.gm.shuai_ping.entity.LoginEntity;
import com.gm.shuai_ping.util.LoginData;

public interface LoginMapper {
    LoginData getUserFromLogin(LoginEntity loginEntity);
    int updateSignInOn(LoginData loginData);
}
