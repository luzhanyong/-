package com.hrm.commons.benas;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 卢占勇
 * @desc
 * @date 2022/3/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SchoolLeader {
    @ExcelProperty("序号")
    private Integer id;
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("职务")
    private String position;
    @ExcelProperty("性别")
    private String sex;
    @ExcelProperty("民族")
    private String nation;
    @ExcelProperty("籍贯")
    private String nativeplc;
    @ExcelProperty("出生年月")
    private String birthday;
    @ExcelProperty("参加工作时间")
    private String worktime;
    @ExcelProperty("入党时间")
    private String theparty;
    @ExcelProperty("任现职级时间")
    private String postime;
    @ExcelProperty("学历")
    private String educationbg;
    @ExcelProperty("学位")
    private String degree;
    @ExcelProperty("毕业院校")
    private String graduateinst;
    @ExcelProperty("职称")
    private String title;
    @ExcelProperty("备注")
    private String comm;
}
