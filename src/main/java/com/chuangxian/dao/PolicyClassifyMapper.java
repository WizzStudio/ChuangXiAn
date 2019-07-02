package com.chuangxian.dao;

import com.chuangxian.entity.PolicyClassify;

import java.util.List;

public interface PolicyClassifyMapper {
    int deleteByPrimaryKey(Integer policyId);

    int insert(PolicyClassify record);

    int insertSelective(PolicyClassify record);

    PolicyClassify selectByPrimaryKey(Integer policyId);

    List<PolicyClassify> selectAll();

    int updateByPrimaryKeySelective(PolicyClassify record);

    int updateByPrimaryKey(PolicyClassify record);
}