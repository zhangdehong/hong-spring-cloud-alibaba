package com.hong.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hong.common.dto.DeptDTO;
import com.hong.common.service.IDeptService;
import com.hong.common.util.DeepBeanUtils;
import com.hong.provider.dao.IDeptDao;
import com.hong.provider.vo.Dept;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  18:56 2022/7/17
 */
@Service
public class DeptServiceImpl implements IDeptService {

    private final IDeptDao deptDao;

    @Autowired
    public DeptServiceImpl (IDeptDao deptDao) {this.deptDao = deptDao;}

    @Override
    public DeptDTO get (Long id) {
        DeptDTO deptDTO = new DeptDTO();
        BeanUtils.copyProperties(this.deptDao.selectById(id), deptDTO);
        return deptDTO;
    }

    @Override
    public boolean add (DeptDTO dto) {
        Dept dept = new Dept();
        BeanUtils.copyProperties(dto, dept);
        return this.deptDao.insert(dept) > 0;
    }

    @Override
    public List<DeptDTO> list () {
        QueryWrapper<Dept> wrapper = new QueryWrapper<>();
        List<DeptDTO> deptDTOS = DeepBeanUtils.copyListProperties(this.deptDao.selectList(wrapper), DeptDTO::new);
        return deptDTOS;
    }

    @Override
    public Map<String, Object> split (int currentPage, int lineSize, String colum, String keyword) {
        QueryWrapper<Dept> wrapper = new QueryWrapper<>();
        // 设置模糊查询
        wrapper.like(colum, keyword);
        // 统计个数
        Integer count = this.deptDao.selectCount(wrapper);
        // 数据查询处理
        Page<Dept> page = this.deptDao.selectPage(new Page<>(currentPage, lineSize, count), wrapper);
        HashMap<String, Object> map = new HashMap<>();
        map.put("allDepts", DeepBeanUtils.copyListProperties(page.getRecords(), DeptDTO::new));
        map.put("allDeptRecords", page.getTotal());
        map.put("allPages", page.getPages());
        return map;
    }
}
