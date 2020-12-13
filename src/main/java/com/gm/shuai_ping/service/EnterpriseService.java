package com.gm.shuai_ping.service;

import com.gm.shuai_ping.entity.Enterprise;

import java.util.List;

public interface EnterpriseService {
    int insert(Enterprise record);
    int deleteByPrimaryKey(Integer id);
    int updateByPrimaryKey(Enterprise record);
    List<Enterprise> selectAll();
    Enterprise selectEnterpriseById(Integer id);

    List<String> getEnterpriseName();
}
