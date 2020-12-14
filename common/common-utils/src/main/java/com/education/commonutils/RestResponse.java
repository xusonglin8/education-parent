package com.education.commonutils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xusonglin
 * @date 2020/10/15 - 13:37
 */
@Data
public class RestResponse {
    private Integer code;

    private String message;

    private Map<String, Object> data = new HashMap<String, Object>();

    private  RestResponse(){}
    //成功静态方法
    public static RestResponse success() {
        RestResponse r = new RestResponse();
        r.setCode(RestResponseCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    //成功静态方法
    public static RestResponse success(String message, Map<String, Object> data) {
        RestResponse r = new RestResponse();
        r.setCode(RestResponseCode.SUCCESS);
        r.setMessage(message);
        r.setData(data);
        return r;
    }

    //失败静态方法
    public static RestResponse error(String message) {
        RestResponse r = new RestResponse();
        r.setCode(RestResponseCode.ERROR);
        r.setMessage(message);
        return r;
    }

    public RestResponse message(String message) {
        this.setMessage(message);
        return this;
    }

    public RestResponse code(Integer code) {
        this.setCode(code);
        return this;
    }

    public RestResponse data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public RestResponse data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}