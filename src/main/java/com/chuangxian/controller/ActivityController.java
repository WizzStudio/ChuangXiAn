package com.chuangxian.controller;

import com.chuangxian.entity.Activity;
import com.chuangxian.entity.dto.ActivityTransforSupport;
import com.chuangxian.service.ActivityService;
import com.chuangxian.util.String2DateUtils;
import com.chuangxian.util.ToolSupport.UniversalResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@RestController
public class ActivityController {
    @Resource
    private ActivityService activityService;

    @PostMapping("/activity/new")
    public UniversalResponseBody newActivity(ActivityTransforSupport record){
        Activity insertData = new Activity();
        insertData.setActivityContent(record.getActivityContent());
        insertData.setActivityId(record.getActivityId());
        insertData.setActivityTitle(record.getActivityTitle());
        insertData.setActivityTime(record.getActivityTime());
        insertData.setEndingTime(String2DateUtils.parseDateStr(record.getEndingTime()));
        insertData.setPublishTime(String2DateUtils.parseDateStr(record.getPublishTime()));
        insertData.setSponsor(record.getSponsor());
        insertData.setBeginningTime(String2DateUtils.parseDateStr(record.getBeginningTime()));
        int activityId = activityService.addNewActivity(insertData);
        if (activityId != -1) {
            return new UniversalResponseBody<>(0, "success",activityId);
        }else{
            return new UniversalResponseBody(-1,"error");
        }
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

    @GetMapping("/activity/page/{page}")
    public UniversalResponseBody getActivityByPage(@PathVariable("page")int pageNumber){
        return new UniversalResponseBody<>(0,"success",activityService.getActivityList(pageNumber));
    }

    @GetMapping("/activity/search/{keyword}/{page}")
    public UniversalResponseBody searchKeyword(@PathVariable("keyword")String keyword,
                                               @PathVariable("page")int page){
        return new UniversalResponseBody<>(0,"success",activityService.searchActivity(page, URLDecoder.decode(keyword, StandardCharsets.UTF_8)));
    }
}
