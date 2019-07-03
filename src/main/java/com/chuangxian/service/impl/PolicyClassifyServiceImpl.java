package com.chuangxian.service.impl;

import com.chuangxian.dao.PolicyClassifyMapper;
import com.chuangxian.entity.PolicyClassify;
import com.chuangxian.service.PolicyClassifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@Slf4j
public class PolicyClassifyServiceImpl implements PolicyClassifyService {
    @Resource
    private PolicyClassifyMapper policyClassifyMapper;


    @Override
    public boolean addNewClassify(PolicyClassify record) {
        boolean flag = false;
        try {
            policyClassifyMapper.insert(record);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Transactional
    public void addNewClassifies(Set<String> classifies) throws Exception {
        for (String classify : classifies) {
            if (policyClassifyMapper.selectByClassify(classify) == null) {
                PolicyClassify record = new PolicyClassify();
                record.setClassify(classify);
                //System.out.println("----"+classify+"-----");
                policyClassifyMapper.insert(record);
            }
        }
    }

    @Override
    public List<PolicyClassify> getAllKindOfClassify() {
        return policyClassifyMapper.selectAll();
    }
}
