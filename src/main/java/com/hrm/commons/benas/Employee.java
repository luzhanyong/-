package com.hrm.commons.benas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
//employee和job（dept）是多对一的关系

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    private Integer id;//编号
    //关联属性Dept
    private Dept dept;//所属部门
    //关联属性Job
    private Job job;//职位
    private String name;//姓名
    private int sex;//性别
    private String nation; //民族
    private String nativeplc;//籍贯
    private String birthday;//出生年月
    private String worktime;//工作时间
    private String theparty;
    private String postime;
    private String educationBg;
    private String degree;
    private String graduateInst;
    private String title;
    private String comment;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date birthday;
//    private String card_id;
//    private String address;
//    private String post_code;
//    private String tel;
//    private String phone;
//    private String qq_num;
//    private String email;
//
//    private String party;
//
//    private String race;
//    private String education;
//    private String speciality;
//    private String hobby;
//    private String remark;
//    private Date create_date;


}
