package com.gm.shuai_ping.controller;

import com.gm.shuai_ping.entity.Enterprise;
import com.gm.shuai_ping.service.impl.EnterpriseServiceImpl;
import com.gm.shuai_ping.util.ResultCode;
import com.gm.shuai_ping.util.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/v1")
public class EnterpriseController {
    @Autowired
    EnterpriseServiceImpl enterpriseService;

    ResultResponse failResultResponse=new ResultResponse(ResultCode.FAIL.getCode(),ResultCode.FAIL.getMessage());


    @GetMapping("/Admin/enterprises")
    public ResultResponse getAllEnterprises(){
        ResultResponse successResultResponse=new ResultResponse(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage());
        List<Enterprise> enterprises = enterpriseService.selectAll();
        if (null == enterprises){
            return failResultResponse;
        }
        successResultResponse.setObjData(enterprises);
        return successResultResponse;
    }

    @GetMapping("/Admin/enterprise/{id}")
    public ResultResponse getEnterpriseById(@PathVariable("id") Integer id){
        ResultResponse successResultResponse=new ResultResponse(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage());
        Enterprise enterprise = enterpriseService.selectEnterpriseById(id);
        if (null == enterprise){
            return failResultResponse;
        }
        successResultResponse.setObjData(enterprise);
        return successResultResponse;
    }

    @PostMapping("/Admin/enterprise")
    public ResultResponse insertEnterprise(@RequestBody Enterprise enterprise){
        ResultResponse successResultResponse=new ResultResponse(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage());
        if (0 == enterpriseService.insert(enterprise)){
            return failResultResponse;
        }
        return successResultResponse;
    }

    @DeleteMapping("/Admin/enterprise")
    public ResultResponse deleteEnterprise(@RequestBody Enterprise enterprise){
        ResultResponse successResultResponse=new ResultResponse(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage());
        if (0 == enterpriseService.deleteByPrimaryKey(enterprise.getId())){
            return failResultResponse;
        }
        return successResultResponse;
    }

    @PutMapping("/Admin/enterprise")
    public ResultResponse updateEnterprise(@RequestBody Enterprise enterprise){
        ResultResponse successResultResponse=new ResultResponse(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage());
        if (0 == enterpriseService.updateByPrimaryKey(enterprise)){
            return failResultResponse;
        }
        return successResultResponse;
    }

}
