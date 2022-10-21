package com.hong.provider.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatisPlus 配置类
 *
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  18:04 2022/7/17
 */
@Configuration
public class MyBatisConfigPlus {

    @Bean
    public MybatisPlusInterceptor getMybatisPlusInterpector () {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(
                // 分页处理
                new PaginationInnerInterceptor(DbType.MYSQL)
        );
        return interceptor;
    }
}
