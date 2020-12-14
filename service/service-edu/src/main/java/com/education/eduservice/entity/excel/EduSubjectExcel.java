package com.education.eduservice.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author xusonglin
 * @date 2020/10/21 - 11:16
 */
@Data
public class EduSubjectExcel {

    @ExcelProperty(index = 0)
    private String firSub;

    @ExcelProperty(index = 1)
    private String secSub;

}
