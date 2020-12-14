package com.education.eduservice.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xusonglin
 * @date 2020/10/16 - 21:21
 */
@Data
public class TeacherVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private Integer level;

    private String begin;

    private String end;
}
