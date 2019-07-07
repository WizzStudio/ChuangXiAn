package com.chuangxian.controller;

import com.chuangxian.entity.Picture;
import com.chuangxian.service.PictureService;
import com.chuangxian.util.FileUtil;
import com.chuangxian.util.ToolSupport.UniversalResponseBody;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Maolin
 * @className ：PictureController
 * @date ：Created in 2019/7/4 10:40
 * @description： Picture upload and show
 * @version: 1.0
 */
@RestController
@RequestMapping("/picture")
@CrossOrigin(allowCredentials = "true")
public class PictureController {
    @Resource
    private FileUtil fileUtil;

    @Resource
    private PictureService pictureService;

    @PostMapping("/upload")
    public UniversalResponseBody uploadFiles(@RequestParam("file") MultipartFile[] file, @RequestParam("id")int id){
        if(fileUtil.uploadHelper(file,id)){
            return new UniversalResponseBody(0,"success");
        }else{
            return new UniversalResponseBody(1,"failed");
        }
    }
    @GetMapping("/show/{activityId}")
    public UniversalResponseBody getPictureURL(@PathVariable("activityId") int activityId){
        List<Picture> temp = pictureService.getPictureByActivityId(activityId);
        List<String> res = new ArrayList<>();
        for (Picture row: temp) {
            res.add(row.getPictureUrl());
        }
        return new UniversalResponseBody<>(0,"success",res);
    }
}

