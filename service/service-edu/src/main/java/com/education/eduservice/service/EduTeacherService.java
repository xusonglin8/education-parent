package com.education.eduservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.education.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.education.eduservice.vo.TeacherVo;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-10-13
 */
public interface EduTeacherService extends IService<EduTeacher> {
    public IPage<EduTeacher> pageTeacherByCondition(int current, int limit, TeacherVo teacherVo);
}
