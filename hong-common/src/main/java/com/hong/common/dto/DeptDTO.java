package com.hong.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  00:21 2022/7/16
 */
@Data
public class DeptDTO implements Serializable {

    // 部门编号
    private Long deptno;
    // 部门名称
    private String dname;
    // 部门位置
    private String loc;
}
