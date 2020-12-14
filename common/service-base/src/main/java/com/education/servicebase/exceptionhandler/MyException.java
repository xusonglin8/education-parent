package com.education.servicebase.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xusonglin
 * @date 2020/10/17 - 11:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyException  extends  RuntimeException{
    private Integer code;
    private String msg;
}
