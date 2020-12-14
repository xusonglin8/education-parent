package com.education.oss.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author xusonglin
 * @date 2020/10/20 - 15:28
 */
@Component
public class ConstantPropertiesUtils implements InitializingBean {

    //读取配置文件内容
    @Value("${aliyun.oss.file.endPoint}")
    private String endPoint;
    @Value("${aliyun.oss.file.keyId}")
    private String keyId;
    @Value("${aliyun.oss.file.keySecret}")
    private String keySecret;
    @Value("${aliyun.oss.file.bucketName}")
    private String bucketName;

    public static String END_POINT;
    public static String KEY_ID;
    public static String KEY_SECRET;
    public static String BUCKET_NAME;
    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endPoint;
        KEY_ID = keyId;
        KEY_SECRET = keySecret;
        BUCKET_NAME  = bucketName;
    }
}
