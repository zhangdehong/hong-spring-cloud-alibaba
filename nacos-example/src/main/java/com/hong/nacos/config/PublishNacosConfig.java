package com.hong.nacos.config;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  22:54 2022/10/11
 */
public class PublishNacosConfig {

    // nacos链接地址
    public static final String NACOS_SERVER = "nacos-server:8848";
    // 命名空间 (nacos中查找)
    public static final String NAMESPACE = "37bc85e2-0f3b-4849-a8d6-172584b62c41";
    // 分组
    public static final String GROUP = "HONG_GROUP";
    // 存储的key
    public static final String DATA_ID = "com.hong.nacos.config";

    public static void main (String[] args) throws NacosException {
        // 要保存的配置项内容
        String content = "hong.zh";
        // 将nacos的相关属性进行配置
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, NACOS_SERVER);
        properties.put(PropertyKeyConst.NAMESPACE, NAMESPACE);
        // 创建配置实例，创建完链接后，会将此链接包装为configService 的对象实例返回，里面包含各种数据操作
        ConfigService configService = NacosFactory.createConfigService(properties);
        // 获取配置项
        // String serviceConfig = configService.getConfig(DATA_ID, GROUP, 5000);
        // 发布配置项
        boolean isOk = configService.publishConfig(DATA_ID, GROUP, content);
        System.err.println(isOk ? "【nacos 配置发布成功】":"【nacos发布失败】");
    }

}
