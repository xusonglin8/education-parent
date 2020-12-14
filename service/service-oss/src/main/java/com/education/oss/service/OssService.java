package com.education.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author xusonglin
 * @date 2020/10/20 - 15:47
 */
public interface OssService {
    public String uploadOssFileAvatar(MultipartFile file);
}
