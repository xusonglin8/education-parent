package com.education.oss.controller;

import com.education.commonutils.RestResponse;
import com.education.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author xusonglin
 * @date 2020/10/20 - 15:47
 */
@RestController
@RequestMapping("/eduoss/file/")
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;
    //头像上传
    @PostMapping("upload")
    public RestResponse uploadOssFile(MultipartFile file){
        String url = ossService.uploadOssFileAvatar(file);
        return RestResponse.success().data("url",url);
    }
}
