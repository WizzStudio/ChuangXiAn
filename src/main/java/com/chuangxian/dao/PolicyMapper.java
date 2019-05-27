package com.chuangxian.dao;

import com.chuangxian.entity.Policy;

public interface PolicyMapper {
    int deleteByPrimaryKey(Integer policyId);

    int insert(Policy record);

    int insertSelective(Policy record);

    Policy selectByPrimaryKey(Integer policyId);

    Policy selectByOriginalUrl(String originalUrl);

    int updateByPrimaryKeySelective(Policy record);

    int updateByPrimaryKeyWithBLOBs(Policy record);

    int updateByPrimaryKey(Policy record);
}