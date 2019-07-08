package com.chuangxian.service;

import com.chuangxian.entity.Policy;
import com.chuangxian.entity.dto.PolicyPreview;

import java.util.List;

public interface PolicyService {
    boolean save(Policy policy);

    void savePolicies(List<Policy> policies) throws Exception;

    Policy findByOriginalUrl(String originalUrl);

    List<PolicyPreview> getPolicyByPage(int page);

    Policy getPolicyById(int id);

    List<PolicyPreview> getPolicyByClassify(int page,String classify);

    List<PolicyPreview> getPolicyByLevel(int page,String level);

    List<PolicyPreview> search(int page,String keyword);

    List<PolicyPreview> getBothSearch(int page, String level, String classify);
}
