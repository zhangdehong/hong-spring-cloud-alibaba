package com.hong.consumer.ribbon;

import com.alibaba.nacos.shaded.com.google.common.collect.Lists;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义的服务列表
 *
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  21:59 2022/10/26
 */
@Component
@Slf4j
public class DefaultServerList implements ServerList<Server> {

    /**
     * 初始化服务列表
     *
     * @return
     */
    @Override
    public List<Server> getInitialListOfServers () {

        return null;
    }

    /**
     * 获取更新后的服务列表
     *
     * @return
     */
    @Override
    public List<Server> getUpdatedListOfServers () {
        // 定义保存服务列表
        List<Server> allServers = Lists.newArrayList();
        allServers.add(new Server("127.0.0.1", 8001));
        allServers.add(new Server("127.0.0.1", 8002));
        log.info("更新服务列表 {}", allServers);
        return allServers;
    }
}
