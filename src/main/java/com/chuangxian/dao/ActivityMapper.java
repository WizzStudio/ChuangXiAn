package com.chuangxian.dao;

import com.chuangxian.entity.Activity;
import com.chuangxian.entity.dto.ActivityPreview;

import java.util.List;
import java.util.Map;

public interface ActivityMapper {
    int deleteByPrimaryKey(Integer activityId);

    int insert(Activity record);

    int insertSelective(Activity record);

    int selectLastId();

    List<ActivityPreview> selectByPage(int pageNumber);

    Activity selectByPrimaryKey(Integer activityId);

    List<ActivityPreview> selectSearch(Map<String,Object> data);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);


}