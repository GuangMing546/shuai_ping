package com.gm.shuai_ping.service.impl;

import com.gm.shuai_ping.entity.Enterprise;
import com.gm.shuai_ping.mapper.EnterpriseMapper;
import com.gm.shuai_ping.service.EnterpriseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Resource
    EnterpriseMapper enterpriseMapper;

    @Override
    public int insert(Enterprise record) {
        return enterpriseMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return enterpriseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Enterprise record) {
        return enterpriseMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Enterprise> selectAll() {
        return enterpriseMapper.selectAll();
    }

    @Override
    public Enterprise selectEnterpriseById(Integer id) {
        return enterpriseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<String> getEnterpriseName() {
        return enterpriseMapper.getEnterpriseName();
    }
}
