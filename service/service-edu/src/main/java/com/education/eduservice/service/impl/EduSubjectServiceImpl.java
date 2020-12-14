package com.education.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.education.eduservice.entity.EduSubject;
import com.education.eduservice.entity.excel.EduSubjectExcel;
import com.education.eduservice.listener.EduSubjectExcelListener;
import com.education.eduservice.mapper.EduSubjectMapper;
import com.education.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-10-21
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {
    @Override
    public void uploadSubject(MultipartFile file,EduSubjectService eduSubjectService){
        try {
            InputStream fileInput = file.getInputStream();
            EasyExcel.read(fileInput, EduSubjectExcel.class,new EduSubjectExcelListener(eduSubjectService)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
