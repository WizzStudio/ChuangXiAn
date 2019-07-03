package com.chuangxian.dao;

import com.chuangxian.entity.PolicyLevel;

import java.util.List;

public interface PolicyLevelMapper {
    int deleteByPrimaryKey(Integer policyId);

    int insert(PolicyLevel record);

    int insertSelective(PolicyLevel record);

    PolicyLevel selectByPrimaryKey(Integer policyId);

    PolicyLevel selectByLevel(String level);

    List<PolicyLevel> selectAll();

    int updateByPrimaryKeySelective(PolicyLevel record);

    int updateByPrimaryKey(PolicyLevel record);
}