package com.gm.shuai_ping.service.impl;

import com.gm.shuai_ping.entity.LoginEntity;
import com.gm.shuai_ping.entity.User;
import com.gm.shuai_ping.mapper.LoginMapper;
import com.gm.shuai_ping.service.LoginService;
import com.gm.shuai_ping.util.JwtUtil;
import com.gm.shuai_ping.util.ResultCode;
import com.gm.shuai_ping.util.ResultData;
import com.gm.shuai_ping.util.ResultResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    LoginMapper loginMapper;

    @Override
    public ResultResponse checkLogin(LoginEntity loginEntity) {
        User user =loginMapper.getUserFromLogin(loginEntity);

        ResultResponse resultResponse=new ResultResponse();

        resultResponse.setCode(ResultCode.FAILLogin.getCode());
        resultResponse.setMessage(ResultCode.FAILLogin.getMessage());

        if (null != user){
            //登录成功，生成token
            String token= JwtUtil.sign(user.getId().toString(),user.getUserName());
            //装配好ResultData
            ResultData resultData=new ResultData(user.getId(),user.getUserName(),user.getRole(),token);
            resultData.setUrl(getURL(loginEntity.getRole()));
            //装配好ResultCode
            resultResponse.setCode(ResultCode.SUCCESSLOGIN.getCode());
            resultResponse.setMessage(ResultCode.SUCCESSLOGIN.getMessage());
            //装配好ResultResponse
            resultResponse.setObjData(resultData);
            return resultResponse;
        }
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
}
