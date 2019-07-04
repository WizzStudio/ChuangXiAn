package com.chuangxian.config;

import com.chuangxian.filter.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author ：Maolin
 * @className ：InterceptorConfig
 * @date ：Created in 2019/7/4 17:27
 * @description： Interceptor config
 * @version: 1.0
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Resource
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(
                "/login/**",
                "/level/**",
                "/policy/**",
                "/classify/**");
    }
}
