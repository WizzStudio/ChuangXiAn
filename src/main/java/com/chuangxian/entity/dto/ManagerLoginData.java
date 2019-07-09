package com.chuangxian.entity.dto;

import com.chuangxian.util.MD5Util;
import com.chuangxian.util.RandomUtil;

/**
 * @author ：Maolin
 * @className ：ManagerLoginData
 * @date ：Created in 2019/7/4 9:16
 * @description：dto of Manager
 * @version: 1.0
 */
public class ManagerLoginData {
    private String managerName;

    private String managerPassword;

    private String session_key;

    public ManagerLoginData() {
    }

    public ManagerLoginData(String managerName, String managerPwd) {
        this.managerName = managerName;
        this.managerPassword = managerPwd;
        this.session_key = setMd5Session();
    }

    public ManagerLoginData(String managerName, String managerPwd, String session_key) {
        this.managerName = managerName;
        this.managerPassword = managerPwd;
        this.session_key = setMd5Session();
    }

    private String setMd5Session() {
        return MD5Util.encrypt(RandomUtil.getSixRandom(16));
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

}
