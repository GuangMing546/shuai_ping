package com.gm.shuai_ping.controller;

import com.gm.shuai_ping.entity.User;
import com.gm.shuai_ping.service.impl.UserServiceImpl;
import com.gm.shuai_ping.util.ResultCode;
import com.gm.shuai_ping.util.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/v1")
public class UsersController {
    @Autowired
    UserServiceImpl userService;

    ResultResponse failResultResponse=new ResultResponse(ResultCode.FAIL.getCode(),ResultCode.FAIL.getMessage());
    ResultResponse successResultResponse=new ResultResponse(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage());

    @GetMapping("/getAllUsers")
    public ResultResponse getAllUsers(){
        List<User> users=userService.getAllUsers();
        if (null == users){
            return failResultResponse;
        }
        successResultResponse.setObjData(users);
        return successResultResponse;
    }

    @GetMapping("/getUserById/{id}")
    public ResultResponse getUserById(@PathVariable("id") Integer id){
        User user = userService.getUserById(id);
        if (null == user){
            return failResultResponse;
        }
        successResultResponse.setObjData(user);
        return successResultResponse;
    }

    @PostMapping("/insertUser")
    public ResultResponse insertUser(@RequestBody User user){
        if (userService.insertUser(user)== 0){
            return failResultResponse;
        }
        return successResultResponse;
    }

    @DeleteMapping("/deleteUser")
    public ResultResponse deleteUser(@RequestBody User user){
        if (userService.deleteUserById(user.getId())== 0){
            return failResultResponse;
        }
        return successResultResponse;
    }

    @PutMapping("/updateUser")
    public ResultResponse updateUser(@RequestBody User user){
        if (userService.updateUser(user)== 0){
            return failResultResponse;
        }
        return successResultResponse;
    }

}
