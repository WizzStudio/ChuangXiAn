package com.chuangxian.service.impl;

import com.chuangxian.dao.PolicyLevelMapper;
import com.chuangxian.entity.PolicyLevel;
import com.chuangxian.service.PolicyLevelService;

import javax.annotation.Resource;
import java.util.List;

public class PolicyLevelServiceImpl implements PolicyLevelService {
    @Resource
    private PolicyLevelMapper policyLevelMapper;

    @Override
    public boolean addNewPolicyLevel(PolicyLevel record) {
        boolean flag = false;
        try{
            policyLevelMapper.insert(record);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public List<PolicyLevel> getAllKindOfPolicyLevel() {
        return policyLevelMapper.selectAll();
    }
}
