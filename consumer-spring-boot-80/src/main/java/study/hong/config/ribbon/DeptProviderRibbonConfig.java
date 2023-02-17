package study.hong.config.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 此类必须使用@Configuration注解
 *
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  00:20 2023/2/13
 */
@Configuration
public class DeptProviderRibbonConfig {

    @Autowired
    private IClientConfig clientConfig;

    @Autowired
    private ServerList serverList;

    @Autowired
    private ServerListUpdater serverListUpdater;

    /**
     * 自定义的负载均衡规则
     * @return
     */
    @Bean
    public IRule ribbonRule () {
        // 随机读取
        return new RandomRule();
    }

    @Bean
    public ILoadBalancer loadBalancer(){
        DynamicServerListLoadBalancer<Server> loadBalancer = new DynamicServerListLoadBalancer<>(this.clientConfig);
        loadBalancer.setServerListImpl(this.serverList);
        loadBalancer.setServerListUpdater(this.serverListUpdater);
        loadBalancer.setRule(this.ribbonRule());
        return loadBalancer;
    }

}
