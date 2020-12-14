package com.education.eduservice.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.education.commonutils.utils.ToolUtils;
import com.education.eduservice.entity.EduTeacher;
import com.education.eduservice.service.EduTeacherService;
import com.education.commonutils.RestResponse;
import com.education.eduservice.vo.TeacherVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-10-13
 */
@Api("用户模块API文档")//注解api说明该类需要生成api文档
@RestController
@RequestMapping("/eduservice/edu-teacher")
@Slf4j
@CrossOrigin
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    //rest风格
    @ApiOperation("查找所有用户")//API中说明的该类的作用
    @GetMapping("findAll")
    public RestResponse findAllTeacher(){
        try{
            List<EduTeacher> list = eduTeacherService.list(null);
            HashMap map = new HashMap();
            map.put("list",list);
            return RestResponse.success("成功",map);
        }
        catch (Exception e){
            String errorMessage = "查找失败";
            log.error(errorMessage,e);
            return RestResponse.error(errorMessage);
        }
    }

    @ApiOperation("根据id删除教师用户")//API中说明的该类的作用
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",//参数名字
                    value = "教师id",//参数的描述
                    required = true,//是否必须传参数，true是
                    paramType = "path",//参数类型 path代表路径参数
                    dataType = "String")//参数类型 String
    })
    @DeleteMapping("deleteById/{id}")
    public RestResponse removeTeacher(@PathVariable String id){
        try{
            Boolean success = eduTeacherService.removeById(id);
            HashMap data = new HashMap();
            data.put("success",success);
            return RestResponse.success("删除成功",data);
        }
        catch (Exception e){
            String errorMessage = "删除失败";
            log.error(errorMessage,e);
            return RestResponse.error(errorMessage);
        }
    }
    @ApiOperation("分页查询")//API中说明的该类的作用
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current",//参数名字
                    value = "当前页",//参数的描述
                    required = true,//是否必须传参数，true是
                    paramType = "path",//参数类型 path代表路径参数
                    dataType = "int"),//参数类型 String
            @ApiImplicitParam(name = "size",//参数名字
                    value = "当前页数量",//参数的描述
                    required = true,//是否必须传参数，true是
                    paramType = "path",//参数类型 path代表路径参数
                    dataType = "int")//参数类型 String
    })
    @GetMapping("pageTeacher/{current}/{size}")
    public RestResponse pageTeacher(@PathVariable int current,@PathVariable  int size){
        try{
            Page<EduTeacher> page = new Page<>(current,size);//默认当前页为1、每页数量为10
            eduTeacherService.page(page,null);
            HashMap data = new HashMap();
            data.put("rows",page);
            return RestResponse.success("成功",data);
        }
        catch (Exception e){
            String errorMessage = "分页查询失败";
            log.error(errorMessage,e);
            return RestResponse.error(errorMessage);
        }
    }
    //条件分页查询
    @PostMapping("pageTeacherByCondition/{current}/{limit}")
    public RestResponse pageTeacherByCondition(@PathVariable int current, @PathVariable  int limit,@RequestBody(required = false) TeacherVo teacherVo){
        try{
            IPage<EduTeacher> page= eduTeacherService.pageTeacherByCondition(current,limit,teacherVo);
            HashMap data = new HashMap();
            data.put("rows",page.getRecords());
            data.put("total",page.getTotal());
            return RestResponse.success("成功",data);
        }
        catch (Exception e){
            String errorMessage = "分页查询失败";
            log.error(errorMessage,e);
            return RestResponse.error(errorMessage);
        }
    }

    //添加讲师
    @PostMapping("addTeacher")
    public RestResponse addTeacher(@RequestBody EduTeacher eduTeacher){
        try{
            boolean save = eduTeacherService.save(eduTeacher);
            HashMap data = new HashMap();
            data.put("id：",eduTeacher.getId());
            return RestResponse.success("成功",data);
        }
        catch (Exception e){
            String errorMessage = "添加教师失败";
            log.error(errorMessage,e);
            return RestResponse.error(errorMessage);
        }
    }

    //根据id进行查询
    @GetMapping("getEduTeacherById/{id}")
    public RestResponse getEduTeacherById(@PathVariable  String id){
        try{
            EduTeacher eduTeacher = eduTeacherService.getById(id);
            HashMap data = new HashMap();
            data.put("teacher",eduTeacher);
            return RestResponse.success("成功",data);
        }
        catch (Exception e){
            String errorMessage = "根据id查询教师失败";
            log.error(errorMessage,e);
            return RestResponse.error(errorMessage);
        }
    }

    //根据id修改
    @PostMapping("updateEduTeacher")
    public RestResponse updateEduTeacher(@RequestBody EduTeacher eduTeacher){
        try{
            Boolean f = eduTeacherService.updateById(eduTeacher);
            HashMap data = new HashMap();
            data.put("teacher",eduTeacher);
            return RestResponse.success("成功",data);
        }
        catch (Exception e){
            String errorMessage = "根据id查询教师失败";
            log.error(errorMessage,e);
            return RestResponse.error(errorMessage);
        }
    }
}

