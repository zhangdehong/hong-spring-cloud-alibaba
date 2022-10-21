package com.hong.provider.test;

import com.hong.common.dto.DeptDTO;
import com.hong.common.service.IDeptService;
import com.hong.provider.ProviderApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Map;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  22:48 2022/9/25
 */
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@SpringBootTest(classes = ProviderApplication.class)
public class TestDeptService {

    @Autowired
    private IDeptService deptService;

    @Test
    public void testGet(){
        System.out.println(this.deptService.get(1L));
    }

    @Test
    public void testList(){
        System.out.println(this.deptService.list());
    }

    @Test
    public void testAdd(){
        DeptDTO deptDTO = new DeptDTO();
        deptDTO.setDeptno(5L);
        deptDTO.setLoc("北京");
        deptDTO.setDname("测试部门");
        System.out.println(this.deptService.add(deptDTO));
    }

    @Test
    public void testSplit(){
        Map<String, Object> maps = this.deptService.split(1, 2, "dname", "");
        System.out.println(maps);
    }
}
