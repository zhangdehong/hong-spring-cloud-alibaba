package com.hong.consumer;

import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.loadbalancer.*;

import java.util.concurrent.TimeUnit;

/**
 * ServerListUpdater 服务实例更新器
 *
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  08:54 2022/11/3
 */
public class TestServerListUpdate {

    public static void main (String[] arges) throws InterruptedException {

        String instances = "10.10.10.3:8001,10.10.10.4:8002,10.10.10.5:8003";
        DefaultClientConfigImpl clientConfig = new DefaultClientConfigImpl();
        // 保存实例数据
        clientConfig.set(CommonClientConfigKey.ListOfServers, instances);
        ConfigurationBasedServerList serverList = new ConfigurationBasedServerList();
        // 通过客户端配置类实现服务列表初始化
        serverList.initWithNiwsConfig(clientConfig);
        PollingServerListUpdater updater = new PollingServerListUpdater();
        updater.start(
                () -> System.out.println("【实例更新】最后更新时间:【" + updater.getLastUpdate()
                        + "】、上次更新时长：【" + updater.getDurationSinceLastUpdateMs() + "】"
                        + "【错误更新的周期数量】：【" + updater.getNumberMissedCycles() + "】"
                        + "【使用线程数量】：【" + updater.getCoreThreads() + "】")
        );
        ZoneAwareLoadBalancer<Server> loadBalancer = new ZoneAwareLoadBalancer<>();
        loadBalancer.setServerListImpl(serverList);
        loadBalancer.setServerListUpdater(updater);
        TimeUnit.SECONDS.sleep(Long.MAX_VALUE);
    }
}
