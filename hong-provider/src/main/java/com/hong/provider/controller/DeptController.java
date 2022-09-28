package com.hong.provider.controller;

import com.hong.common.dto.DeptDTO;
import com.hong.common.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  22:30 2022/7/19
 */
@RestController
@RequestMapping("/provider/dept/*")
public class DeptController {

    @Autowired
    private IDeptService deptService;

    @GetMapping("get/{id}")
    public Object getDept (@PathVariable("id") long id) {
        return this.deptService.get(id);
    }

    @PostMapping("add")
    public Object add (DeptDTO deptDTO) {
        return deptService.add(deptDTO);
    }

    @PostMapping("list")
    public Object list () {
        return deptService.list();
    }

    @PostMapping("split")
    public Object split (int number, int limit, String column, String keyword) {
        return deptService.split(number, limit, column, keyword);
    }
}
