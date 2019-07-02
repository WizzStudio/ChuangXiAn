package com.chuangxian.service.impl;

import com.chuangxian.dao.ManagerMapper;
import com.chuangxian.entity.Manager;
import com.chuangxian.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
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
}
