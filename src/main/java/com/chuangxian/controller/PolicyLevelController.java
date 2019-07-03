package com.chuangxian.controller;

import com.chuangxian.entity.PolicyLevel;
import com.chuangxian.service.PolicyLevelService;
import com.chuangxian.util.ToolSupport.UniversalResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PolicyLevelController {
    @Resource
    private PolicyLevelService policyLevelService;

    @GetMapping("/level")
    public UniversalResponseBody getAllLevel(){
        return new UniversalResponseBody<>(0,"success",policyLevelService.getAllKindOfPolicyLevel());
    }
}
