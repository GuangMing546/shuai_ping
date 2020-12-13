package com.gm.shuai_ping.service.impl;

import com.gm.shuai_ping.entity.LoginEntity;
import com.gm.shuai_ping.mapper.LoginMapper;
import com.gm.shuai_ping.service.LoginService;
import com.gm.shuai_ping.util.JwtUtil;
import com.gm.shuai_ping.util.ResultCode;
import com.gm.shuai_ping.util.LoginData;
import com.gm.shuai_ping.util.ResultResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    LoginMapper loginMapper;

    @Override
    public ResultResponse checkLogin(LoginEntity loginEntity) {
        ResultResponse resultResponse=new ResultResponse();

        //通过用户名和密码查询数据库
        LoginData resultData =loginMapper.getUserFromLogin(loginEntity);
        if (null != resultData){
            //登录成功，生成token
            String token= JwtUtil.sign(changeRole(loginEntity.getRole()),loginEntity.getUserName());
            //装配好ResultData
            resultData.setToken(token);
            resultData.setUrl(getURL(loginEntity.getRole())); //装好url
            //装配好ResultCode
            resultResponse.setCode(ResultCode.SUCCESSLOGIN.getCode());
            resultResponse.setMessage(ResultCode.SUCCESSLOGIN.getMessage());
            //装配好ResultResponse
            resultResponse.setObjData(resultData);
            return resultResponse;
        }
        resultResponse.setCode(ResultCode.FAILLogin.getCode());
        resultResponse.setMessage(ResultCode.FAILLogin.getMessage());
        return resultResponse;
    }

    private String getURL(String role){
        String url=null;
        switch (role){
            case "1":
                url="/index";
                break;
            case "2":
                url="/";
                break;
            case "3":
                url="/test";
                break;
            default:
                break;
        }
        return url;
    }

    private String changeRole(String role){
        switch (role){
            case "1":
                role="Admin";
                break;
            case "2":
                role="User";
                break;
            case "3":
                role="Enterprise";
                break;
            default:
                break;
        }
        return role;
    }
}
