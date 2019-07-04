package com.chuangxian.service.impl;

import com.chuangxian.dao.ManagerMapper;
import com.chuangxian.entity.Manager;
import com.chuangxian.entity.dto.ManagerLoginData;
import com.chuangxian.service.ManagerService;
import com.chuangxian.util.ToolSupport.CacheResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private ManagerMapper managerMapper;

    @Override
    public boolean addNewManager(Manager record) {
        boolean flag = false;
        try{
            managerMapper.insert(record);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Manager getManagerById(int id) {
        return managerMapper.selectByPrimaryKey(id);
    }

    @Override
    @CachePut(value = "managerCache", key = "'sessionKey::'+#loginData.session_key", condition = "#result.session_key != null")
    public CacheResponseBody managerLogin(ManagerLoginData loginData){
        try {
            Manager manager = managerMapper.selectByManagerName(loginData.getManagerName());
            if (manager == null) {
                return new CacheResponseBody(-1, "User does not exist!");
            } else if (!manager.getManagerPassword().equals(loginData.getManagerPassword())) {
                return new CacheResponseBody(-1, "wrong password！");
            } else {
                return new CacheResponseBody<>(0, "success", manager);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("【登陆】登陆失败", e);
            return new CacheResponseBody(-1, "failed");
        }
    }
}
