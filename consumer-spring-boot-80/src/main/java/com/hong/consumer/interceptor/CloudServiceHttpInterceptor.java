package com.hong.consumer.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  16:09 2022/10/4
 */
@Slf4j
@Component
public class CloudServiceHttpInterceptor implements ClientHttpRequestInterceptor {


    @Override
    public ClientHttpResponse intercept (HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution execution) throws IOException {
        log.info("【Http请求拦截】服务主机：{},REST 路径 {}",
                httpRequest.getURI().getHost(), httpRequest.getURI().getPath());
        httpRequest.getHeaders().set("token", "www.henley.com");
        // 发送请求
        return execution.execute(httpRequest, bytes);
    }
}
