package com.hong.common.service;

import com.hong.common.dto.DeptDTO;

import java.util.List;
import java.util.Map;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  00:45 2022/7/16
 */
public interface IDeptService {

    /**
     * 根据部门编号获取部门的完整信息
     *
     * @param id 部门编号
     * @return 不存在返回null
     */
    DeptDTO get (Long id);

    /**
     * 增加部门对象
     *
     * @param dto 要保存的部门对象信息
     * @return
     */
    boolean add (DeptDTO dto);

    /**
     * 部门集合
     *
     * @return
     */
    List<DeptDTO> list ();

    /**
     * 部门分页数据加载操作
     *
     * @param currentPage 当前所在页
     * @param lineSize    每页加载的数据行数
     * @param colum       模糊查询的数据列
     * @param keyword     模糊查询关键字
     * @return  部门数据集合
     */
    Map<String, Object> split (int currentPage, int lineSize, String colum, String keyword);
}
