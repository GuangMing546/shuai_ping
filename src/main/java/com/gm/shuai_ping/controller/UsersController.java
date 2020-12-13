package com.gm.shuai_ping.controller;

import com.gm.shuai_ping.entity.User;
import com.gm.shuai_ping.service.impl.UserServiceImpl;
import com.gm.shuai_ping.util.ResultCode;
import com.gm.shuai_ping.util.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/v1")
public class UsersController {
    @Autowired
    UserServiceImpl userService;

    ResultResponse failResultResponse=new ResultResponse(ResultCode.FAIL.getCode(),ResultCode.FAIL.getMessage());


    @GetMapping("/Admin/users")
    public ResultResponse getAllUsers(){
        ResultResponse successResultResponse=new ResultResponse(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage());
        List<User> users=userService.getAllUsers();
        if (null == users){
            return failResultResponse;
        }
        successResultResponse.setObjData(users);
        return successResultResponse;
    }

    @GetMapping("/Admin/user/{id}")
    public ResultResponse getUserById(@PathVariable("id") Integer id){
        ResultResponse successResultResponse=new ResultResponse(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage());
        User user = userService.getUserById(id);
        if (null == user){
            return failResultResponse;
        }
        successResultResponse.setObjData(user);
        return successResultResponse;
    }

    @PostMapping("/Admin/user")
    public ResultResponse insertUser(@RequestBody User user){
        ResultResponse successResultResponse=new ResultResponse(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage());
        System.out.println(new Date(System.currentTimeMillis()));
        if (userService.insertUser(user)== 0){
            return failResultResponse;
        }
        return successResultResponse;
    }

    @DeleteMapping("/Admin/user")
    public ResultResponse deleteUser(@RequestBody User user){
        ResultResponse successResultResponse=new ResultResponse(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage());
        if (userService.deleteUserById(user.getId())== 0){
            return failResultResponse;
        }
        return successResultResponse;
    }

    @PutMapping("/Admin/user")
    public ResultResponse updateUser(@RequestBody User user){
        ResultResponse successResultResponse=new ResultResponse(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage());
        if (userService.updateUser(user)== 0){
            return failResultResponse;
        }
        return successResultResponse;
    }

}
