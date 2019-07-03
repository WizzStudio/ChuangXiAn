package com.chuangxian.controller;

import com.chuangxian.service.PolicyClassifyService;
import com.chuangxian.util.ToolSupport.UniversalResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PolicyClassifyController {
    @Resource
    private PolicyClassifyService policyClassifyService;

    @GetMapping("/classify")
    public UniversalResponseBody getAllClassify(){
        return new UniversalResponseBody<>(0,"success",policyClassifyService.getAllKindOfClassify());

    }
}
