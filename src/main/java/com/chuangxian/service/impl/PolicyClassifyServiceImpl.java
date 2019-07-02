package com.chuangxian.service.impl;

import com.chuangxian.dao.PolicyClassifyMapper;
import com.chuangxian.entity.PolicyClassify;
import com.chuangxian.service.PolicyClassifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PolicyClassifyServiceImpl implements PolicyClassifyService {
    @Resource
    private PolicyClassifyMapper policyClassifyMapper;


    @Override
    public boolean addNewClassify(PolicyClassify record) {
        boolean flag = false;
        try{
            policyClassifyMapper.insert(record);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<PolicyClassify> getAllKindOfClassify() {
        return policyClassifyMapper.selectAll();
    }
}
