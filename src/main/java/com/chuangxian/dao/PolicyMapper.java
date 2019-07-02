package com.chuangxian.dao;

import com.chuangxian.entity.Policy;

import java.util.List;

public interface PolicyMapper {
    int deleteByPrimaryKey(Integer policyId);

    int insert(Policy record);

    int insertSelective(Policy record);

    List<Policy> selectByPageNumber(int pageNumber);

    Policy selectByPrimaryKey(Integer policyId);

    Policy selectByOriginalUrl(String originalUrl);

    int updateByPrimaryKeySelective(Policy record);

    int updateByPrimaryKeyWithBLOBs(Policy record);

    int updateByPrimaryKey(Policy record);
}