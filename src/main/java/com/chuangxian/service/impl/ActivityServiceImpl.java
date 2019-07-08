package com.chuangxian.service.impl;

import com.chuangxian.dao.ActivityMapper;
import com.chuangxian.entity.Activity;
import com.chuangxian.entity.dto.ActivityPreview;
import com.chuangxian.service.ActivityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Resource
    private ActivityMapper activityMapper;


    @Override
    @Transactional
    public int addNewActivity(Activity record) {
        int flag = -1;
        try{
            activityMapper.insert(record);
            flag = activityMapper.selectLastId();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteActivity(int id) {
        boolean flag = false;
        try {
            activityMapper.deleteByPrimaryKey(id);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<ActivityPreview> getActivityList(int pageNumber) {
        //从0开始
        pageNumber--;
        return activityMapper.selectByPage(pageNumber);
    }

    @Override
    public Activity getActivity(int id) {
        return activityMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ActivityPreview> searchActivity(int page, String keyword) {
        page--;
        Map<String,Object> data = new HashMap<>();
        data.put("pageNumber",page);
        data.put("keyword",keyword);
        return activityMapper.selectSearch(data);
    }
}
