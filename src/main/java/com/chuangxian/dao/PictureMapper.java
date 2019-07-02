package com.chuangxian.dao;

import com.chuangxian.entity.Picture;

import java.util.List;

public interface PictureMapper {
    int deleteByPrimaryKey(Integer pictureId);

    int insert(Picture record);

    int insertSelective(Picture record);

    List<Picture> selectByActivityId(int activityId);

    Picture selectByPrimaryKey(Integer pictureId);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);
}