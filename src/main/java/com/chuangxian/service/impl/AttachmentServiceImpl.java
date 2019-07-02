package com.chuangxian.service.impl;

import com.chuangxian.dao.AttachmentMapper;
import com.chuangxian.entity.Attachment;
import com.chuangxian.service.AttachmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AttachmentServiceImpl implements AttachmentService {
    @Resource
    private AttachmentMapper attachmentMapper;

    @Override
    public boolean addNewAttachment(Attachment record) {
        boolean flag = false;
        try{
            attachmentMapper.insert(record);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteAttachment(int policyId) {
        boolean flag = false;
        try{
            // TODO: 2019/7/2 设置数据库方法使其删除相关政策的附件信息
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Attachment> getAttachmentByPolicyId(int policyId) {
        return attachmentMapper.selectByPolicyId(policyId);
    }
}
