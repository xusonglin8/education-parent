package com.education.eduservice.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author xusonglin
 * @date 2020/10/14 - 15:16
 */
@Configuration
public class eduConfig {
    //逻辑删除的插件
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }
    //性能查询插件
    //dev:开发环境
    //test：测试环境
    //prod：生产环境
    @Bean
    @Profile({"dev","test"})//设置在哪种环境下开启
    public PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(500);
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }
    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
