package com.hong.nacos;

import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * 服务实例注册
 *
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  12:18 2022/10/13
 */

public class RegisterNacosInstance {

    // nacos链接地址
    public static final String NACOS_SERVER = "nacos-server:8848";
    // 命名空间 (nacos中查找)
    public static final String NAMESPACE = "37bc85e2-0f3b-4849-a8d6-172584b62c41";
    // 分组
    public static final String GROUP = "HONG_GROUP";
    // 存储的key
    public static final String INSTANCE_ID = "cloud.provider.dept";

    public static void main (String[] args) throws NacosException, InterruptedException {
        // 将nacos的相关属性进行配置
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, NACOS_SERVER);
        properties.put(PropertyKeyConst.NAMESPACE, NAMESPACE);
        // 此时发布的并不是配置项，而是服务，需要创建命名服务实例
        NamingService namingService = NamingFactory.createNamingService(properties);
        // 准备向nacos注册中心进行服务的注册处理
        namingService.registerInstance(INSTANCE_ID, GROUP, "127.0.0.1", 8888, "deptProviderCluster");
        // 注册成功之后，保证持续像nacos发送心跳
        TimeUnit.MINUTES.sleep(Long.MAX_VALUE);
    }
}
