package com.chuangxian.service;

import com.chuangxian.entity.Attachment;

import java.util.List;

public interface AttachmentService {
    //添加相关活动的附件
    boolean addNewAttachment(Attachment record);
    //删除活动相关附件
    boolean deleteAttachment(int policyId);
    //获得与相关政策有关的附件
    List<Attachment> getAttachmentByPolicyId(int policyId);
}
