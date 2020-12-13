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

    ResultResponse resultResponse=new ResultResponse();

    @Override
    public ResultResponse checkLogin(LoginEntity loginEntity) {
        resultResponse.setCode(ResultCode.FAILLogin.getCode());
        resultResponse.setMessage(ResultCode.FAILLogin.getMessage());
        //通过用户名和密码查询数据库
        LoginData loginData =loginMapper.getUserFromLogin(loginEntity);
        if (null != loginData){
            //判断这个用户是否已经登录
            if(loginData.getSignIn()==1){
                resultResponse.setCode(ResultCode.ALREADYLogin.getCode());
                resultResponse.setMessage(ResultCode.ALREADYLogin.getMessage());
                return resultResponse;
            }
            //登录成功，生成token
            String token= JwtUtil.sign(changeRole(loginEntity.getRole()),loginEntity.getUserName());
            //装配好ResultData
            loginData.setToken(token);  //装好token
            loginData.setUrl(getURL(loginEntity.getRole())); //装好url
            //装配好ResultResponse
            resultResponse.setObjData(loginData);
            resultResponse.setCode(ResultCode.SUCCESSLOGIN.getCode());
            resultResponse.setMessage(ResultCode.SUCCESSLOGIN.getMessage());

            //修改后台的登录状态
            loginData.setRole(loginEntity.getRole());
            loginMapper.updateSignInOnFromLogin(loginData);

            return resultResponse;
        }

        return resultResponse;
    }

    @Override
    public ResultResponse exit(LoginData loginData) {
        System.out.println(loginData);
        if (loginMapper.updateSignInFromExit(loginData)==1){
            resultResponse.setCode(ResultCode.SUCCESSEXIT.getCode());
            resultResponse.setMessage(ResultCode.SUCCESSEXIT.getMessage());
            return resultResponse;
        }
        resultResponse.setCode(ResultCode.FAILEXIT.getCode());
        resultResponse.setMessage(ResultCode.FAILEXIT.getMessage());
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
