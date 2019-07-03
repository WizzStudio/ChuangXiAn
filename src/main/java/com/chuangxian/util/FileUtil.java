package com.chuangxian.util;


import com.chuangxian.entity.Picture;
import com.chuangxian.service.PictureService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
@Service
public class FileUtil {
    @Resource
    private PictureService pictureService;
    /**
     * 使用uploadHelper来将多文件拆解，在调用单个文件上传函数，加入事务管理
     * @param temp 从前端传来的多文件List
     * @return 返回是否全部上传成功
     */
    @Transactional
    public boolean uploadHelper(MultipartFile[] temp, int activityId){
        boolean flag = true;
        for(int incr = 0;incr < temp.length;incr++){
            try {
                if (temp[incr].getOriginalFilename() == null || temp[incr].getOriginalFilename().equals("")) {
                    continue;
                }
            }catch (NullPointerException e){
                e.printStackTrace();
            }
            if(upload(temp[incr],activityId)){
                flag = true;
            }else {
                flag = false;
            }
        }
        return flag;
    }

    private boolean upload(MultipartFile file,int activityId){
        try{
            if(file.isEmpty()){
                return false;
            }
            //重新构造文件名，防止文件名重复
            String fileName = String.valueOf(new Date().getTime());
            //Please replace the file path in you particular project.
            String path = "/root/uploadpicture/" + fileName + "_" + activityId;
            String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            path = path + fileType;
            Picture temp = new Picture();
            String picUrl = "/image/photo/" + fileName + "_" + activityId + fileType;
            temp.setPictureUrl(picUrl);
            temp.setActivityId(activityId);
            java.io.File ttep = new java.io.File(path);
            if(!ttep.getParentFile().exists()){
                ttep.getParentFile().mkdir();
            }
            try {
                byte[] bytes = file.getBytes();
                Path paths = Paths.get(path);
                Files.write(paths, bytes);
                //Call the service to insert file url into database
                this.pictureService.addNewPicture(temp);
            }catch (IOException e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
