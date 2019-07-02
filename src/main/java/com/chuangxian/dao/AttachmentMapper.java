package com.chuangxian.dao;

import com.chuangxian.entity.Attachment;

import java.util.List;

public interface AttachmentMapper {
    int deleteByPrimaryKey(Integer attachmentId);

    int insert(Attachment record);

    int insertSelective(Attachment record);

    List<Attachment> selectByPolicyId(int policyId);

    Attachment selectByPrimaryKey(Integer attachmentId);

    int updateByPrimaryKeySelective(Attachment record);

    int updateByPrimaryKey(Attachment record);
}