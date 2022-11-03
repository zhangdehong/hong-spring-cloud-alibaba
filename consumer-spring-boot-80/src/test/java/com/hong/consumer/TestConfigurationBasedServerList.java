package com.hong.consumer;

import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.loadbalancer.ConfigurationBasedServerList;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  23:13 2022/10/29
 */
public class TestConfigurationBasedServerList {

    public static void main (String[] args) {
        String instance = "10.30.2.2:8001,10.3.2.3:8002,3.5.4.3:8003";
        DefaultClientConfigImpl clientConfig = new DefaultClientConfigImpl();
        clientConfig.set(CommonClientConfigKey.ListOfServers,instance);
        ConfigurationBasedServerList serverList = new ConfigurationBasedServerList();
        serverList.initWithNiwsConfig(clientConfig);
        System.out.println(serverList.getInitialListOfServers());
    }
}
