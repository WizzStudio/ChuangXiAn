package com.chuangxian.entity;

public class PolicyClassify {
    private Integer policyId;

    private String classify;

    private String englishClassify;

    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }

    public String getEnglishClassify() {
        return englishClassify;
    }

    public void setEnglishClassify(String englishClassify) {
        this.englishClassify = englishClassify == null ? null : englishClassify.trim();
    }
}