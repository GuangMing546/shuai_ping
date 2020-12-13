package com.gm.shuai_ping.service;

import com.gm.shuai_ping.entity.LoginEntity;
import com.gm.shuai_ping.util.LoginData;
import com.gm.shuai_ping.util.ResultResponse;

public interface LoginService {
    ResultResponse checkLogin(LoginEntity loginEntity);
    ResultResponse exit(LoginData loginData);
}
