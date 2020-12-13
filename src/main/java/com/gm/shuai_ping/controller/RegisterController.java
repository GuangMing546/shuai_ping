package com.gm.shuai_ping.controller;

import com.gm.shuai_ping.entity.Enterprise;
import com.gm.shuai_ping.entity.User;
import com.gm.shuai_ping.service.impl.EnterpriseServiceImpl;
import com.gm.shuai_ping.service.impl.UserServiceImpl;
import com.gm.shuai_ping.util.ResultCode;
import com.gm.shuai_ping.util.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin //解决跨域问题
@RestController //@Controller @ResponseBody
@RequestMapping("/v1")
public class RegisterController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    EnterpriseServiceImpl enterpriseService;

    ResultResponse failResultResponse=new ResultResponse(ResultCode.FAILREGISTER.getCode(),ResultCode.FAILREGISTER.getMessage());
    ResultResponse successResultResponse=new ResultResponse(ResultCode.SUCCESSREGISTER.getCode(),ResultCode.SUCCESSREGISTER.getMessage());

    @PostMapping("/getAllUserName")
    public List<String> getAllUserName(){
        return userService.getAllUserName();
    }

    @PostMapping("/userRegister")
    public ResultResponse userRegister(@RequestBody User user){
        if(userService.insertUser(user) == 1){
            return successResultResponse;
        }
        return failResultResponse;
    }

    @PostMapping("/getAllEnterpriseName")
    public List<String> getAllEnterpriseName(){
        return enterpriseService.getEnterpriseName();
    }

    @PostMapping("/enterpriseRegister")
    public ResultResponse enterpriseRegister(@RequestBody Enterprise enterprise){
        if(enterpriseService.insert(enterprise) == 1){
            return successResultResponse;
        }
        return failResultResponse;
    }
}
