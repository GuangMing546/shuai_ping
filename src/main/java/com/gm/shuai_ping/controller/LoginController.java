package com.gm.shuai_ping.controller;

import com.gm.shuai_ping.entity.LoginEntity;
import com.gm.shuai_ping.service.impl.LoginServiceImpl;
import com.gm.shuai_ping.util.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin //解决跨域问题
@RestController //@Controller @ResponseBody
@RequestMapping("/v1")

public class LoginController {
    @Autowired
    LoginServiceImpl loginService;

    @PostMapping("/login")
    public ResultResponse checkLogin(@RequestBody LoginEntity loginEntity){
        System.out.println(loginEntity);
        return loginService.checkLogin(loginEntity);
    }

    @PostMapping("/test")
    public String test(){
        return "你好啊 召唤师";
    }

}
