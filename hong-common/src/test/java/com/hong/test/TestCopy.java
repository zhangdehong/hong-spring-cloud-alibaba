package com.hong.test;

import com.hong.common.dto.DeptDTO;
import com.hong.common.util.DeepBeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  01:13 2022/7/16
 */
public class TestCopy {

    public static void main (String[] args) {
        List<DeptDTO> sources = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DeptDTO deptDTO = new DeptDTO();
            deptDTO.setDeptno(10L + i);
            deptDTO.setDname("hong - " + i);
            deptDTO.setLoc("北京");
            sources.add(deptDTO);
        }
        List<DeptDTO> deptDTOList = DeepBeanUtils.copyListProperties(sources, DeptDTO::new);
        deptDTOList.forEach(System.out::println);
    }
}
