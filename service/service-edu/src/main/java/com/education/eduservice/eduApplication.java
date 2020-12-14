package com.education.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xusonglin
 * @date 2020/10/14 - 15:02
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.education"})
public class eduApplication {
    public static void main(String[] args) {
        SpringApplication.run(eduApplication.class,args);
    }
}
