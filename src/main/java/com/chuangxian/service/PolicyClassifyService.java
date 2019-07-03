package com.chuangxian.service;

import com.chuangxian.entity.PolicyClassify;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PolicyClassifyService {
    //添加新等级
    boolean addNewClassify(PolicyClassify record);

    void addNewClassifies(Set<String> classifies) throws Exception;

    //获取所有等级
    List<PolicyClassify> getAllKindOfClassify();
}
