package com.hong.common.util;


import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * 扩充bean工具类
 *
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  00:58 2022/7/16
 */
public class DeepBeanUtils extends BeanUtils {

    public DeepBeanUtils () {}

    /**
     * 实现list集合对象的拷贝处理
     *
     * @param source 原始对象
     * @param target 目标对象集合
     * @param <S>    源对象类型
     * @param <T>    目标对象类型
     * @return
     */
    public static <S, T> List<T> copyListProperties (List<S> sources, Supplier<T> target) {
        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            // 获取数据
            T obj = target.get();
            // 数据拷贝
            copyProperties(source, obj);
            list.add(obj);
        }
        return list;
    }
}
