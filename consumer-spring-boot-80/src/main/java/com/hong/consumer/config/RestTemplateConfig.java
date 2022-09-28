package com.hong.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <h1>rest template 配置类</>
 *
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  00:45 2022/9/29
 */
@Configuration
public class RestTemplateConfig {

    /**
     * 发送http请求和接受http响应的rest template
     * @return
     */
    @Bean
    public RestTemplate restTemplate () {
        return new RestTemplate();
    }

}
