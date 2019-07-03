package com.chuangxian.controller;

import com.chuangxian.entity.Activity;
import com.chuangxian.service.ActivityService;
import com.chuangxian.util.ToolSupport.UniversalResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ActivityController {
    @Resource
    private ActivityService activityService;

    @PostMapping("/activity/new")
    public UniversalResponseBody newActivity(Activity record){
        return new UniversalResponseBody(0,"success");
    }

    @GetMapping("/activity/detail/{id}")
    public UniversalResponseBody getActivityDetail(@PathVariable("id")int id){
        Activity res = activityService.getActivity(id);
        if(res.getSponsor().equals("")){
            return new UniversalResponseBody(-1,"error");
        }else{
            return new UniversalResponseBody<>(0,"success",res);
        }
    }

    @GetMapping("/acticity/page/{page}")
    public UniversalResponseBody getActivityByPage(@PathVariable("page")int pageNumber){
        return new UniversalResponseBody<>(0,"success",activityService.getActivityList(pageNumber));
    }
}
