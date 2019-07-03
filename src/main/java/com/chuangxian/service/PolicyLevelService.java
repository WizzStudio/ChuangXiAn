package com.chuangxian.service;

import com.chuangxian.entity.PolicyLevel;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PolicyLevelService {
    //添加新的classLevel
    boolean addNewPolicyLevel(PolicyLevel record);

    void addNewPolicyLevels(Set<String> levels) throws Exception;

    List<PolicyLevel> getAllKindOfPolicyLevel();
}
