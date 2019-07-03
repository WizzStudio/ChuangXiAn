package com.chuangxian.service.impl;

import com.chuangxian.dao.PolicyLevelMapper;
import com.chuangxian.entity.PolicyLevel;
import com.chuangxian.service.PolicyLevelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class PolicyLevelServiceImpl implements PolicyLevelService {
    @Resource
    private PolicyLevelMapper policyLevelMapper;

    @Override
    public boolean addNewPolicyLevel(PolicyLevel record) {
        boolean flag = false;
        try {
            policyLevelMapper.insert(record);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Transactional
    public void addNewPolicyLevels(Set<String> levels) throws Exception {
        for (String level : levels) {
            if (policyLevelMapper.selectByLevel(level) == null) {
                PolicyLevel record = new PolicyLevel();
                record.setLevel(level);
                policyLevelMapper.insert(record);
            }
        }
    }

    @Override
    public List<PolicyLevel> getAllKindOfPolicyLevel() {
        return policyLevelMapper.selectAll();
    }
}
