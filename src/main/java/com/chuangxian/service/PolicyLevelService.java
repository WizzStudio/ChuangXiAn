package com.chuangxian.service;

import com.chuangxian.entity.PolicyLevel;

import java.util.List;

public interface PolicyLevelService {
    //添加新的classLevel
    boolean addNewPolicyLevel(PolicyLevel record);

    List<PolicyLevel> getAllKindOfPolicyLevel();
}
