package com.chuangxian.dao;

import com.chuangxian.entity.UserInformation;

public interface UserInformationMapper {
    int deleteByPrimaryKey(Integer mainId);

    int insert(UserInformation record);

    int insertSelective(UserInformation record);

    UserInformation selectByPrimaryKey(Integer mainId);

    UserInformation selectByOpenId(String openId);

    int deleteByOpenId(String openId);

    int updateByPrimaryKeySelective(UserInformation record);

    int updateByPrimaryKey(UserInformation record);
}