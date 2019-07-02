package com.chuangxian.controller;

import com.chuangxian.util.ToolSupport.UniversalResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PolicyController {
    @GetMapping("/policy/{page}")
    public UniversalResponseBody getPolicyByPage(@PathVariable("page") int page){
        return new UniversalResponseBody(0,"success");
    }
}
