package com.hong.consumer.config;

import com.hong.consumer.interceptor.CloudServiceHttpInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * <h1>rest template 配置类</>
 *
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  00:45 2022/9/29
 */
@Configuration
public class RestTemplateConfig {

    private final CloudServiceHttpInterceptor interceptor;

    @Autowired
    public RestTemplateConfig (CloudServiceHttpInterceptor interceptor) {this.interceptor = interceptor;}

    /**
     * 发送http请求和接受http响应的rest template
     *
     * @return RestTemplate
     */
    @Bean
    public RestTemplate restTemplate () {
        RestTemplate template = new RestTemplate();
        template.setInterceptors(Collections.singletonList(this.interceptor));
        return template;
    }

}
