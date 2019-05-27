package com.chuangxian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.chuangxian.dao")
@EnableTransactionManagement
@Configuration
@EnableScheduling
public class ChuangXiAnApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChuangXiAnApplication.class, args);
    }

}
