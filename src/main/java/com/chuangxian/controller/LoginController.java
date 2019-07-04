package com.chuangxian.controller;

import com.chuangxian.entity.Manager;
import com.chuangxian.entity.dto.ManagerLoginData;
import com.chuangxian.entity.dto.WxInfo;
import com.chuangxian.service.ManagerService;
import com.chuangxian.service.UserInformationService;
import com.chuangxian.util.ToolSupport.CacheResponseBody;
import com.chuangxian.util.ToolSupport.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

@RestController
@Slf4j
@RequestMapping("/login")
public class LoginController {

    @Resource
    private UserInformationService userInformationService;

    @Resource
    private ManagerService managerService;


    @Autowired
    private RedisTemplate redisTemplate;

    @Cacheable(value = "userCache", key = "#loginData.session_key", condition = "#loginData.session_key !=null")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public CacheResponseBody wechatLogin(@NotNull WxInfo loginData) {
        try {
            return userInformationService.userLoginWechat(loginData);
        } catch (Exception e) {
            log.error(" 【微信登录】登录失败", e);
            e.printStackTrace();
            return new CacheResponseBody(-1, "failed");
        }
    }

    @GetMapping("/check/session")
    public UniversalResponseBody checkSession(String session) {
        boolean flag = redisTemplate.hasKey("userCache::" + session);
        if (flag) {
            return new UniversalResponseBody(0, "success");
        } else {
            log.info("日志信息：访问拦截。提交的session过期" + session);
            return new UniversalResponseBody(102, "failed");
        }
    }

    @Cacheable(value = "managerCache", key = "'sessionKey::'+#loginData.session_key", condition = "#loginData.session_key !=null")
    @RequestMapping(value = "/manager", method = RequestMethod.POST)
    public CacheResponseBody Login(@NotNull ManagerLoginData loginData, HttpServletRequest request) {
        try {
            return managerService.managerLogin(loginData);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("【manager登陆】登陆失败", e);
            return new CacheResponseBody(-1, "failed");
        }
    }
}
