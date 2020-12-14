package com.education.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.education.commonutils.utils.ToolUtils;
import com.education.eduservice.entity.EduSubject;
import com.education.eduservice.entity.excel.EduSubjectExcel;
import com.education.eduservice.service.EduSubjectService;
import com.education.servicebase.exceptionhandler.MyException;


/**
 * @author xusonglin
 * @date 2020/10/21 - 11:27
 */
public class EduSubjectExcelListener extends AnalysisEventListener<EduSubjectExcel> {

  public EduSubjectService eduSubjectService;
  public EduSubjectExcelListener(){}
  public EduSubjectExcelListener(EduSubjectService eduSubjectService){
      this.eduSubjectService = eduSubjectService;
  }
    @Override
    public void invoke(EduSubjectExcel eduSubjectExcel, AnalysisContext analysisContext) {
      if(ToolUtils.isEmpty(eduSubjectExcel)){
         throw new MyException(500,"文件数据为空");
      }
      //一行一行读取
        EduSubject firEduSubject = eduSubjectIsExit(eduSubjectService,eduSubjectExcel.getFirSub(),"0");
        if(ToolUtils.isEmpty(firEduSubject)){
            firEduSubject = new EduSubject();
            firEduSubject.setParentId("0");
            firEduSubject.setTitle(eduSubjectExcel.getFirSub());
            eduSubjectService.save(firEduSubject);
        }

        String pid = firEduSubject.getId();
        EduSubject secEduSubject = eduSubjectIsExit(eduSubjectService,eduSubjectExcel.getSecSub(),pid);
        if(ToolUtils.isEmpty(secEduSubject)){
            secEduSubject = new EduSubject();
            secEduSubject.setParentId(pid);
            secEduSubject.setTitle(eduSubjectExcel.getSecSub());
            eduSubjectService.save(secEduSubject);
        }
    }
    //判断分类不能重复
    private EduSubject eduSubjectIsExit(EduSubjectService eduSubjectService,String name,String pid){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("title",name);
        wrapper.eq("parent_id",pid);
      EduSubject eduSubject = eduSubjectService.getOne(wrapper);
      return  eduSubject;
    }
    //判断二级分类不能重复
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
