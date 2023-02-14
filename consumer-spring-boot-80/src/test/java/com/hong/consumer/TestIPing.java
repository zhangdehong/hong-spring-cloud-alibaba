package com.hong.consumer;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.Server;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  22:36 2023/2/12
 */
public class TestIPing {

    public static void main (String[] args) {
        String host = "hong-provider";
        String uri = "/provider/dept/list";
        IPing ping = new PingUrl();
        Server server = new Server(host, 8001);
        System.out.println(ping.isAlive(server));
    }
}
