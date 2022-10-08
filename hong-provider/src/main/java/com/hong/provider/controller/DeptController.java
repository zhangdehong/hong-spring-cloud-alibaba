package com.hong.provider.controller;

import com.hong.common.dto.DeptDTO;
import com.hong.common.service.IDeptService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  22:30 2022/7/19
 */
@Slf4j
@RestController
@RequestMapping("/provider/dept/*")
public class DeptController {

    @Autowired
    private IDeptService deptService;

    @ApiOperation(value = "部门查询", notes = "根据部门编号查询部门信息")
    @GetMapping("get/{id}")
    public Object getDept (@PathVariable("id") long id) {
        this.printRequestHeaders("/provider/dept/get");
        return this.deptService.get(id);
    }

    @ApiOperation(value = "增加部门信息", notes = "增加新的部门信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deptDTO", required = true,
                    dataType = "DeptDTO", value = "部门传输对象示例")
    })
    @PostMapping("add")
    public Object add (@RequestBody DeptDTO deptDTO) {
        this.printRequestHeaders("/provider/dept/add");
        return deptService.add(deptDTO);
    }

    @ApiOperation(value = "查询部门列表", notes = "查询部门的完整信息")
    @PostMapping("list")
    public Object list () {
        this.printRequestHeaders("/provider/dept/list");
        return deptService.list();
    }

    @ApiOperation(value = "部门分页查询", notes = "根据指定的参数实现部门数据的分页加载")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "number", value = "当前所在页", required = true),
            @ApiImplicitParam(name = "limit", value = "每页显示的数据行数", required = true),
            @ApiImplicitParam(name = "column", value = "模糊查询列", required = true),
            @ApiImplicitParam(name = "keyword", value = "关键词", required = true),
    })
    @PostMapping("split")
    public Object split (int number, int limit, String column, String keyword) {
        this.printRequestHeaders("/provider/dept/split");
        return deptService.split(number, limit, column, keyword);
    }

    /**
     * 实现所有请求头信息的输出
     */
    private void printRequestHeaders (String restName) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Enumeration<String> names = request.getHeaderNames();
        while (names.hasMoreElements()) {
            String headerName = names.nextElement();
            log.info("【{}】头信息 {} = {}", restName, headerName, request.getHeader(headerName));
        }
    }
}
