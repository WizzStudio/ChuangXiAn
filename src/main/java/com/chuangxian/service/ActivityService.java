package com.chuangxian.service;

import com.chuangxian.entity.Activity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ActivityService {
    //添加新活动
    int addNewActivity(Activity record);
    //删除活动
    boolean deleteActivity(int id);
    //获取一组活动
    List<Activity> getActivityList(int pageNumber);
    //获取一条活动
    Activity getActivity(int id);
}
