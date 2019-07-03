package com.chuangxian.controller;

import com.chuangxian.service.PolicyService;
import com.chuangxian.util.ToolSupport.UniversalResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PolicyController {
    @Resource
    private PolicyService policyService;

    @GetMapping("/policy/{page}")
    public UniversalResponseBody getPolicyByPage(@PathVariable("page") int page){
        return new UniversalResponseBody<>(0,"success",policyService.getPolicyByPage(page));
    }

    @GetMapping("/policy/detail/{id}")
    public UniversalResponseBody getPolicyDetail(@PathVariable("id")int id){
        return new UniversalResponseBody<>(0,"success",policyService.getPolicyById(id));
    }

    @GetMapping("/policy/classify/{classify}/{page}")
    public UniversalResponseBody getClassifyPolicy(@PathVariable("classify")String classify,
                                                   @PathVariable("page")int page){
        return new UniversalResponseBody<>(0,"success",
                policyService.getPolicyByClassify(page,classify));
    }

    @GetMapping("/policy/level/{level}/{page}")
    public UniversalResponseBody getLevelPolicy(@PathVariable("level")String level,
                                                @PathVariable("page")int page){
        return new UniversalResponseBody<>(0,"success",
                policyService.getPolicyByLevel(page,level));
    }

    @GetMapping("/policy/search/{keyword}")
    public UniversalResponseBody search(@PathVariable("keyword")String keyword){
        return new UniversalResponseBody<>(0,"success",policyService.search(keyword));
    }
}
