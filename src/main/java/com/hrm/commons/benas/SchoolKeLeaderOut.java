package com.hrm.commons.benas;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 卢占勇
 * @desc
 * @date 2022/3/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SchoolKeLeaderOut {
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
    @ExcelProperty("任副科时间")
    private String zktime;
    @ExcelProperty("任正科时间")
    private String fktime;
    @ExcelProperty("任现职时间")
    private String postime;
    @ExcelProperty({"全日制", "学历"})
    private String q_educationbg;
    @ExcelProperty({"全日制", "学位"})
    private String q_degree;
    @ExcelProperty({"全日制", "毕业院校专业"})
    private String q_graduateinst;
    @ExcelProperty({"在职", "学历"})
    private String z_educationbg;
    @ExcelProperty({"在职", "学位"})
    private String z_degree;
    @ExcelProperty({"在职", "毕业院校专业"})
    private String z_graduateinst;
    @ExcelProperty("职称")
    private String title;
    @ExcelProperty("备注")
    private String comm;
}
