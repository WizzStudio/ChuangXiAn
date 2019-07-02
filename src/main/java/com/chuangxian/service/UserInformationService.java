package com.chuangxian.service;

import com.chuangxian.dto.WxInfo;
import com.chuangxian.entity.UserInformation;
import com.chuangxian.util.ToolSupport.CacheResponseBody;

/**
 * @Author: MaoLin
 * @Date: 2019/3/24 11:04
 * @Version 1.0
 */
public interface UserInformationService {

    CacheResponseBody<UserInformation> userLoginWechat(WxInfo loginData) throws Exception;

    boolean save(UserInformation user);

    UserInformation findById(int mainId);

    UserInformation findByOpenId(String openId);

    boolean deleteById(int mainId);

    boolean deleteByOpenId(String openId);

    boolean update(UserInformation user);

}

