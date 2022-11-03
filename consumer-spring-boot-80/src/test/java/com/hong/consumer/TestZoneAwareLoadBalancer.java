package com.hong.consumer;

import com.netflix.loadbalancer.LoadBalancerStats;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerStats;
import com.netflix.loadbalancer.ZoneAwareLoadBalancer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  16:09 2022/10/30
 */
public class TestZoneAwareLoadBalancer<T> {

    public static void main (String[] args) {
        List<Server> servList = new ArrayList<>();
        servList.add(createServer("tj", "hong.provider-8001", 8001));
        servList.add(createServer("bj", "hong.provider-8002", 8002));
        servList.add(createServer("sh", "hong.provider-8003", 8003));

        // 负载均衡算法配置
        ZoneAwareLoadBalancer<Server> loadBalancer = new ZoneAwareLoadBalancer<>();
        loadBalancer.addServers(servList);
        LoadBalancerStats loadBalancerStats = loadBalancer.getLoadBalancerStats();
        loadBalancerStats.updateServerList(servList);
        loadBalancerStats.getServerStats().forEach((server, serverStats) -> {
            if (server.getZone().equals("tj")) {
                loadBalancer.markServerDown(server);
            }
        });
        for (int i = 0; i < loadBalancer.getServerCount(true); i++) {
            // 服务筛选
            System.out.println(loadBalancer.chooseServer(null));
        }
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
