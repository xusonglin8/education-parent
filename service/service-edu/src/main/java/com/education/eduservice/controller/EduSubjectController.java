package com.education.eduservice.controller;


import com.education.commonutils.RestResponse;
import com.education.eduservice.service.EduSubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-10-21
 */
@RestController
@RequestMapping("/eduservice/edu-subject")
@CrossOrigin
@Slf4j
public class EduSubjectController {
    @Autowired
    private EduSubjectService eduSubjectService;

//获取上传过来的文件
    @PostMapping("uploadSubject")
    public RestResponse uploadSubject(MultipartFile file){
        eduSubjectService.uploadSubject(file,eduSubjectService);
        return RestResponse.success();
    }
    //获取上传过来的文件
    @PostMapping("getAllSubject")
    public RestResponse getAllSubject(MultipartFile file){
        eduSubjectService.uploadSubject(file,eduSubjectService);
        return RestResponse.success();
    }
}

