package com.hrm.commons.benas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 卢占勇
 * @desc
 * @date 2022/3/21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Result {

    private Integer code;
    private String message;

}
