package com.education.eduservice.controller;

import com.education.commonutils.RestResponse;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author xusonglin
 * @date 2020/10/19 - 11:28
 */
@RestController
@RequestMapping("/eduservice/user/")
@CrossOrigin
public class EduLoginController {
    // 登录
    @PostMapping("login")
    public RestResponse login(){
        HashMap map = new HashMap();
        map.put("token","admin");
        return RestResponse.success("成功",map);
    }

    //获取登录信息
    @GetMapping("getUserInfo")
    public RestResponse getUserInfo(){
        HashMap map = new HashMap();
        map.put("roles","[admin]");
        map.put("name","admin");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return RestResponse.success("获取成功",map);
    }
}
