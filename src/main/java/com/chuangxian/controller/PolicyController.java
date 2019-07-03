package com.chuangxian.controller;

import com.chuangxian.service.PolicyService;
import com.chuangxian.util.ToolSupport.UniversalResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@RestController
@CrossOrigin
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
                policyService.getPolicyByClassify(page, URLDecoder.decode(classify, StandardCharsets.UTF_8)));
    }

    @GetMapping("/policy/level/{level}/{page}")
    public UniversalResponseBody getLevelPolicy(@PathVariable("level")String level,
                                                @PathVariable("page")int page){
        return new UniversalResponseBody<>(0,"success",
                policyService.getPolicyByLevel(page,URLDecoder.decode(level,StandardCharsets.UTF_8)));
    }

    @GetMapping("/policy/search/{keyword}/{page}")
    public UniversalResponseBody search(@PathVariable("keyword")String keyword,
                                        @PathVariable("page") int page){
        return new UniversalResponseBody<>(0,"success",policyService.search(page,URLDecoder.decode(keyword,StandardCharsets.UTF_8)));
    }
}
