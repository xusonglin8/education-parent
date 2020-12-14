package com.education.eduservice.service;

import com.education.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-10-21
 */
public interface EduSubjectService extends IService<EduSubject> {
    void uploadSubject(MultipartFile file,EduSubjectService eduSubjectService);
}
