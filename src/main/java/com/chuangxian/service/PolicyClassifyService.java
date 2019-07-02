package com.chuangxian.service;

import com.chuangxian.entity.PolicyClassify;

import java.util.List;

public interface PolicyClassifyService {
    //添加新等级
    boolean addNewClassify(PolicyClassify record);
    //获取所有等级
    List<PolicyClassify> getAllKindOfClassify();
}
