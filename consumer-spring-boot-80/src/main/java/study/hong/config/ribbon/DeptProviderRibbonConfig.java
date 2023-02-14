package study.hong.config.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
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

    /**
     * 自定义的负载均衡规则
     * @return
     */
    @Bean
    public IRule ribbonRule () {
        // 随机读取
        return new RandomRule();
    }

}
