package com.chuangxian.entity.dto;

public class PolicyPreview {
    private int policyId;

    private String policyTitle;

    private String publishInstitution;

    private String publishTime;

    public int getPolicyId() {
        return policyId;
    }

    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

    public String getPolicyTitle() {
        return policyTitle;
    }

    public void setPolicyTitle(String policyTitle) {
        this.policyTitle = policyTitle;
    }

    public String getPublishInstitution() {
        return publishInstitution;
    }

    public void setPublishInstitution(String publishInstitution) {
        this.publishInstitution = publishInstitution;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }
}
