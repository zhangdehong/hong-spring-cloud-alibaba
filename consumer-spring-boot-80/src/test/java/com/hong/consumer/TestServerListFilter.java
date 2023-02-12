package com.hong.consumer;

import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfigKey;
import com.netflix.config.ConfigurationManager;
import com.netflix.config.DeploymentContext;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ZoneAffinityServerListFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>通过过滤器的形式实现了所有服务列表之中指定区域的服务列表实例的数据获取</h1>
 *
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  21:55 2022/11/19
 */
public class TestServerListFilter {

    public static void main (String[] args) {
        // 保存服务实例
        List<Server> serverList = new ArrayList<>();
        serverList.add(createServer("hong", "hong.provider-8001", 8001));
        serverList.add(createServer("hong", "hong.provider-8002", 8002));
        serverList.add(createServer("henley", "hong.provider-8003", 8003));
        // 所有与ribbon相关的配置项都是通过IClientConfig接口定义的 (application.yml)
        DefaultClientConfigImpl clientConfig = new DefaultClientConfigImpl();
        // 定义区域的相关性
        clientConfig.set(IClientConfigKey.Keys.EnableZoneAffinity, true);
        // 区域独占性
        clientConfig.set(IClientConfigKey.Keys.EnableZoneExclusivity, true);
        // 区域的优先配置
        ConfigurationManager.getDeploymentContext().setValue(
                DeploymentContext.ContextKey.zone, "hong"
        );
        // 区域可用性的过滤
        ZoneAffinityServerListFilter filter = new ZoneAffinityServerListFilter();
        // 初始化配置
        filter.initWithNiwsConfig(clientConfig);
        // 过滤处理
        System.out.println(filter.getFilteredListOfServers(serverList));
    }

    /**
     * 创建server
     *
     * @param zone
     * @param url
     * @param index
     * @return
     */
    public static Server createServer (String zone, String url, int index) {
        // 创建实例
        Server server = new Server(url, index);
        // 设置区域
        server.setZone(zone);
        return server;
    }
}
