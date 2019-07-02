package com.chuangxian.service;

import com.chuangxian.entity.Manager;
import com.chuangxian.entity.Picture;

import java.util.List;

public interface PictureService {
    //添加关联图片
    boolean addNewPicture(Picture record);
    //删除关联图片
    boolean deletePicture(int id);
    //按照活动id获取相关图片
    List<Picture> getPictureByActivityId(int activityId);
}
