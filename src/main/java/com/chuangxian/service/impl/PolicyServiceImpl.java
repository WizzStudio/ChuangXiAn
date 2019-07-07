package com.chuangxian.service.impl;

import com.chuangxian.dao.PolicyMapper;
import com.chuangxian.entity.Policy;
import com.chuangxian.entity.dto.PolicyPreview;
import com.chuangxian.service.PolicyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<PolicyPreview> getPolicyByPage(int page) {
        page--;
        return policyMapper.selectByPageNumber(page);
    }

    @Override
    public Policy getPolicyById(int id) {
        return policyMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PolicyPreview> getPolicyByClassify(int page, String classify) {
        Map<String,Object> data = new HashMap<>();
        page--;
        data.put("pageNumber",page);
        data.put("classify",classify);
        return policyMapper.selectByClassify(data);
    }

    @Override
    public List<PolicyPreview> getPolicyByLevel(int page,String level) {
        Map<String,Object> data = new HashMap<>();
        page--;
        data.put("pageNumber",page);
        data.put("level",level);
        return policyMapper.selectByLevel(data);
    }

    @Override
    public List<PolicyPreview> search(int page,String keyword)
    {
        Map<String,Object> data = new HashMap<>();
        page--;
        data.put("pageNumber",page);
        data.put("keyword",keyword);
        return policyMapper.searchPolicy(data);
    }

    @Override
    public List<PolicyPreview> getBothSearch(int page, String level, String classify) {
        Map<String,Object> data = new HashMap<>();
        page--;
        data.put("pageNumber",page);
        data.put("level",level);
        data.put("classify",classify);
        return policyMapper.selectByBothLevelAndClassify(data);
    }
}
