package com.hrm.commons.benas;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;

/**
 * @author 卢占勇
 * @desc
 * @date 2022/3/20
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SchoolChuLeader {
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
    @ExcelProperty("任副处时间")
    private String zctime;
    @ExcelProperty("任正处时间")
    private String fctime;
    @ExcelProperty("任现职时间")
    private String postime;
    @ExcelProperty(index = 12)
    private String q_educationbg;
    @ExcelProperty(index = 13)
    private String q_degree;
    @ExcelProperty(index = 14)
    private String q_graduateinst;
    @ExcelProperty(index = 15)
    private String z_educationbg;
    @ExcelProperty(index = 16)
    private String z_degree;
    @ExcelProperty(index = 17)
    private String z_graduateinst;
    @ExcelProperty("职称")
    private String title;
    @ExcelProperty("备注")
    private String comm;
}
