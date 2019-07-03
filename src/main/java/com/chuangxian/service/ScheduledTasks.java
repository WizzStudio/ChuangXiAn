package com.chuangxian.service;

import com.chuangxian.service.PolicyService;
import com.chuangxian.util.XiAnPolicyCrawler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;

//@Component
public class ScheduledTasks {

    @Resource
    private PolicyService policyService;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 定时器毫秒级别
     * initialDelay 初次执行任务之前需要等待的时间
     * fixedRate    执行频率 --5小时
     */
    @Scheduled(initialDelay = 1000 * 60 * 5, fixedRate = 1000 * 60 * 60 * 5)
    public void XiAnPolicyCrawlerSchedule() {
        XiAnPolicyCrawler crawler = new XiAnPolicyCrawler("src/main/resources/crawl/", true, 1, 0);
        try {
            crawler.start(3);
            policyService.savePolicies(crawler.result());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 定时执行，只执行一次，全部爬虫存入数据库
     * 表达式：5月27日16：28：00 开始执行
    */
    @Scheduled(cron = "0 10 18 03 7 * ")
    public void firstXiAnPolicyCrawler() {
        for (int page = 1; page <= 18; page++) {
            XiAnPolicyCrawler crawler = new XiAnPolicyCrawler("src/main/resources/crawl/", true, page, 0);
            try {
                crawler.start(3);
                policyService.savePolicies(crawler.result());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}