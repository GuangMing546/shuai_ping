package com.gm.shuai_ping.mapper;

import com.gm.shuai_ping.entity.Enterprise;
import java.util.List;

public interface EnterpriseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise
     *
     * @mbg.generated
     */
    int insert(Enterprise record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise
     *
     * @mbg.generated
     */
    Enterprise selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise
     *
     * @mbg.generated
     */
    List<Enterprise> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Enterprise record);

    //自己加的方法
    List<String> getEnterpriseName();
}