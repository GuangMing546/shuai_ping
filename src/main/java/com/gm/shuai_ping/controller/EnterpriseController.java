package com.gm.shuai_ping.controller;

import com.gm.shuai_ping.entity.Enterprise;
import com.gm.shuai_ping.service.impl.EnterpriseServiceImpl;
import com.gm.shuai_ping.util.ResultCode;
import com.gm.shuai_ping.util.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/v1")
public class EnterpriseController {
    @Autowired
    EnterpriseServiceImpl enterpriseService;

    ResultResponse failResultResponse=new ResultResponse(ResultCode.FAIL.getCode(),ResultCode.FAIL.getMessage());
    ResultResponse successResultResponse=new ResultResponse(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage());

    @GetMapping("/getAllEnterprises")
    public ResultResponse getAllEnterprises(){
        List<Enterprise> enterprises = enterpriseService.selectAll();
        if (null == enterprises){
            return failResultResponse;
        }
        successResultResponse.setObjData(enterprises);
        return successResultResponse;
    }

    @GetMapping("/getEnterpriseById/{id}")
    public ResultResponse getEnterpriseById(@PathVariable("id") Integer id){
        Enterprise enterprise = enterpriseService.selectEnterpriseById(id);
        if (null == enterprise){
            return failResultResponse;
        }
        successResultResponse.setObjData(enterprise);
        return successResultResponse;
    }

    @PostMapping("/insertEnterprise")
    public ResultResponse insertEnterprise(@RequestBody Enterprise enterprise){
        if (0 == enterpriseService.insert(enterprise)){
            return failResultResponse;
        }
        return successResultResponse;
    }

    @DeleteMapping("/deleteEnterprise")
    public ResultResponse deleteEnterprise(@RequestBody Enterprise enterprise){
        if (0 == enterpriseService.deleteByPrimaryKey(enterprise.getId())){
            return failResultResponse;
        }
        return successResultResponse;
    }

    @PutMapping("/updateEnterprise")
    public ResultResponse updateEnterprise(@RequestBody Enterprise enterprise){
        if (0 == enterpriseService.updateByPrimaryKey(enterprise)){
            return failResultResponse;
        }
        return successResultResponse;
    }

}
