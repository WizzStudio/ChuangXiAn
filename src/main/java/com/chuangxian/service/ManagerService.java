package com.chuangxian.service;

import com.chuangxian.entity.Manager;
import com.chuangxian.entity.dto.ManagerLoginData;
import com.chuangxian.util.ToolSupport.CacheResponseBody;

public interface ManagerService {
    //添加新管理员
    boolean addNewManager(Manager record);
    //获取管理员信息
    Manager getManagerById(int id);

    CacheResponseBody managerLogin(ManagerLoginData managerLoginData);
}
