package com.education.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.education.commonutils.utils.ToolUtils;
import com.education.eduservice.entity.EduTeacher;
import com.education.eduservice.mapper.EduTeacherMapper;
import com.education.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.eduservice.vo.TeacherVo;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-10-13
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Override
    public IPage<EduTeacher> pageTeacherByCondition(int current, int limit, TeacherVo teacherVo) {
        Page<EduTeacher> page = new Page<>(current,limit);
        IPage<EduTeacher> ipage = null;
        if(ToolUtils.isEmpty(teacherVo)){
            ipage = page(page, null);
        }else{
            QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();
            String name = teacherVo.getName();
            Integer level = teacherVo.getLevel();
            String begin = teacherVo.getBegin();
            String end =  teacherVo.getEnd();
            if(!ToolUtils.isEmpty(name)){
                queryWrapper.like("name",name);
            }
            if(!ToolUtils.isEmpty(level)){
                queryWrapper.eq("level",level);
            }
            //TODO 时间查询未生效
            if(!ToolUtils.isEmpty(begin)) {
                queryWrapper.ge("gmt_create",begin);
            }
            if(!ToolUtils.isEmpty(end)) {
                queryWrapper.le("gmt_create",end);
            }
            queryWrapper.orderByDesc("gmt_create");
            ipage = this.page(page, queryWrapper);
        }
        return ipage;
    }
}
