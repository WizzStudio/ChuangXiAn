package com.chuangxian.service;

import com.chuangxian.entity.Policy;

import java.util.List;

public interface PolicyService {
    boolean save(Policy policy);

    void savePolicies(List<Policy> policies) throws Exception;

    Policy findByOriginalUrl(String originalUrl);

    List<Policy> getPolicyByPage(int page);

    Policy getPolicyById(int id);
}
