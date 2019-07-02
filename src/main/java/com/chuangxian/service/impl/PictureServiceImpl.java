package com.chuangxian.service.impl;

import com.chuangxian.dao.PictureMapper;
import com.chuangxian.entity.Manager;
import com.chuangxian.entity.Picture;
import com.chuangxian.service.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PictureServiceImpl implements PictureService {
    @Resource
    private PictureMapper pictureMapper;

    @Override
    public boolean addNewPicture(Picture record) {
        boolean flag = false;
        try {
            pictureMapper.insert(record);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deletePicture(int id) {
        boolean flag = false;
        try{
            pictureMapper.deleteByPrimaryKey(id);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Picture> getPictureByActivityId(int activityId) {
        return pictureMapper.selectByActivityId(activityId);
    }
}
