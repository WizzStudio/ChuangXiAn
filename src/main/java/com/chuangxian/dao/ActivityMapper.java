package com.chuangxian.dao;

import com.chuangxian.entity.Activity;

import java.util.List;

public interface ActivityMapper {
    int deleteByPrimaryKey(Integer activityId);

    int insert(Activity record);

    int insertSelective(Activity record);

    int selectLastId();

    List<Activity> selectByPage(int pageNumber);

    Activity selectByPrimaryKey(Integer activityId);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);
}