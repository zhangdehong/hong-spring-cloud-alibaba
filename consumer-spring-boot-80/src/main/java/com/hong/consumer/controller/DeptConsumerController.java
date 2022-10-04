package com.hong.consumer.controller;

import com.hong.common.dto.DeptDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  20:49 2022/9/29
 */
@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerController {

    // 定义要访问的部门微服务所需要的核心路径前缀
    public static final String DEPT_GET_URL = "http://localhost:8081/provider/dept/get/";
    public static final String DEPT_ADD_URL = "http://localhost:8081/provider/dept/add";
    public static final String DEPT_LIST_URL = "http://localhost:8081/provider/dept/list";
    public static final String DEPT_SPLIT_URL = "http://localhost:8081/provider/dept/split";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/add")
    public Object addDept (DeptDTO deptDTO) {
        // 需要将当前的对象传输到当前的部门微服务中  此时需要restTemplate 处理
        return this.restTemplate.postForObject(DEPT_ADD_URL, deptDTO, Boolean.class);
    }

    @GetMapping("/get")
    public Object get (Long deptNo) {
        // 需要将当前的对象传输到当前的部门微服务中  此时需要restTemplate 处理
        return this.restTemplate.getForObject(DEPT_GET_URL + deptNo, DeptDTO.class);
    }


    @GetMapping("/list")
    public Object list () {
        // 需要将当前的对象传输到当前的部门微服务中  此时需要restTemplate 处理
        return this.restTemplate.postForObject(DEPT_LIST_URL,null, List.class);
    }

    @GetMapping("/split")
    public Object split (int number, int limit, String column, String keyword) {
        // 需要将当前的对象传输到当前的部门微服务中  此时需要restTemplate 处理
        return this.restTemplate.postForObject(DEPT_SPLIT_URL + "?number=" + number + "&limit=" + limit + "&column=" + column + "&keyword=" + keyword,null, Map.class);
    }

}
