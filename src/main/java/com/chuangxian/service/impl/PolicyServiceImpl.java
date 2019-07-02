package com.chuangxian.service.impl;

import com.chuangxian.dao.PolicyMapper;
import com.chuangxian.entity.Policy;
import com.chuangxian.service.PolicyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Service("PolicyService")
public class PolicyServiceImpl implements PolicyService {
    @Resource
    private PolicyMapper policyMapper;

    @Override
    public boolean save(Policy policy) {
        boolean flag = false;
        try {
            policyMapper.insert(policy);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Transactional
    public void savePolicies(List<Policy> policies) throws Exception {
        for (Policy policy : policies) {
            //通过originalUrl判断是否存在，无则插入
            if (policyMapper.selectByOriginalUrl(policy.getOriginalUrl()) == null) {
                policyMapper.insert(policy);
            }
        }
    }

    @Override
    public Policy findByOriginalUrl(String originalUrl) {
        try {
            return policyMapper.selectByOriginalUrl(originalUrl);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Policy> getPolicyByPage(int page) {
        page--;
        return policyMapper.selectByPageNumber(page);
    }

    @Override
    public Policy getPolicyById(int id) {
        return policyMapper.selectByPrimaryKey(id);
    }
}
