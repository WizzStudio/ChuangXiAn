package com.chuangxian.service;

import com.chuangxian.entity.Activity;
import com.chuangxian.entity.dto.ActivityPreview;

import java.util.List;


public interface ActivityService {
    //添加新活动
    int addNewActivity(Activity record);
    //删除活动
    boolean deleteActivity(int id);
    //活动搜索
    List<ActivityPreview> searchActivity(int page,String keyword);
    //获取一组活动
    List<ActivityPreview> getActivityList(int pageNumber);
    //获取一条活动
    Activity getActivity(int id);
}
