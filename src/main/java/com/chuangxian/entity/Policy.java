package com.chuangxian.entity;

import java.util.Date;

public class Policy {
    private Integer policyId;

    private String poicyTitle;

    private String level;

    private String publishInstitution;

    private String issuedNum;

    private String classify;

    private Date publishTime;

    private String imageUrl;

    private String fileUrl;

    private String originalUrl;

    private String policyContent;

    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    public String getPoicyTitle() {
        return poicyTitle;
    }

    public void setPoicyTitle(String poicyTitle) {
        this.poicyTitle = poicyTitle == null ? null : poicyTitle.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getPublishInstitution() {
        return publishInstitution;
    }

    public void setPublishInstitution(String publishInstitution) {
        this.publishInstitution = publishInstitution == null ? null : publishInstitution.trim();
    }

    public String getIssuedNum() {
        return issuedNum;
    }

    public void setIssuedNum(String issuedNum) {
        this.issuedNum = issuedNum == null ? null : issuedNum.trim();
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl == null ? null : originalUrl.trim();
    }

    public String getPolicyContent() {
        return policyContent;
    }

    public void setPolicyContent(String policyContent) {
        this.policyContent = policyContent == null ? null : policyContent.trim();
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyId=" + policyId +
                ", poicyTitle='" + poicyTitle + '\'' +
                ", level='" + level + '\'' +
                ", publishInstitution='" + publishInstitution + '\'' +
                ", issuedNum='" + issuedNum + '\'' +
                ", classify='" + classify + '\'' +
                ", publishTime=" + publishTime +
                ", imageUrl='" + imageUrl + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", originalUrl='" + originalUrl + '\'' +
                ", policyContent='" + policyContent + '\'' +
                '}';
    }
}