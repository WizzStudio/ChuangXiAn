package com.chuangxian.dao;

import com.chuangxian.entity.Policy;
import com.chuangxian.entity.dto.PolicyPreview;

import java.util.List;
import java.util.Map;

public interface PolicyMapper {
    int deleteByPrimaryKey(Integer policyId);

    int insert(Policy record);

    int insertSelective(Policy record);

    List<PolicyPreview> selectByPageNumber(int pageNumber);

    List<PolicyPreview> selectByClassify(Map<String,Object> data);

    List<PolicyPreview> selectByLevel(Map<String,Object> data);

    Policy selectByPrimaryKey(Integer policyId);

    Policy selectByOriginalUrl(String originalUrl);

    List<PolicyPreview> searchPolicy(String keyword);

    int updateByPrimaryKeySelective(Policy record);

    int updateByPrimaryKeyWithBLOBs(Policy record);

    int updateByPrimaryKey(Policy record);
}