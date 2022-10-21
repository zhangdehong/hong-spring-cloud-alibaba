package com.hong.provider.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: ZhangDeHong
 * @describe: TODO
 * @date Create by  18:19 2022/7/17
 */
@Data
@TableName("dept")
public class Dept {

    @TableId(type = IdType.AUTO)
    private Long deptno;
    private String dname;
    private String loc;
}
