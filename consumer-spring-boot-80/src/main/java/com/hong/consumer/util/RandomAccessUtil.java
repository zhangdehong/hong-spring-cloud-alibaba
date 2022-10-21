package com.hong.consumer.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  00:19 2022/10/21
 */
@Component
@Slf4j
public class RandomAccessUtil {

    // 注入微服务中nacos发现客户端
    private final DiscoveryClient discoveryClient;

    @Autowired
    public RandomAccessUtil (DiscoveryClient discoveryClient) {this.discoveryClient = discoveryClient;}

    /**
     * 根据微服务的名称来获取完整的微服务的处理路径
     *
     * @param serviceName 微服务名称
     * @param uri         相对访问路径
     * @return 返回完整的路径
     */
    public String getTargetUri (String serviceName, String uri) {
        // 根据指定的服务名称获取指定的实例名称
        List<ServiceInstance> instances = this.discoveryClient.getInstances(serviceName);
        // 没有该服务名称实例
        if (instances.size() == 0) {
            throw new RuntimeException("nacos 服务名称实例无法获取，拜拜！");
        }
        List<String> list = instances.stream().map(instance -> instance.getUri().toString() + uri)
                .collect(Collectors.toList());
        int anInt = ThreadLocalRandom.current().nextInt(list.size());
        String targetUrl = list.get(anInt);
        log.info("获取nacos实例的服务地址：{}",targetUrl);
        return targetUrl;
    }
}
