package com.hong.provider.config;

import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * swagger 安全配置
 *
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  10:59 2022/10/8
 */
@Configuration
public class SwaggerWebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String DEFAULT_PASSWORD = "{bcrypt}$2a$10$mR3W/FOPL8BDlKG0r7XIK.14TIdWstVNxVY1fG34cn72A8Nn8p5hW";


    @Bean
    public PasswordEncoder getPasswordEncoder () {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("swagger")
                .password(DEFAULT_PASSWORD)
                .roles("USER", "ADMIN");
    }

    @Override
    protected void configure (HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/swagger-ui/**", "/v2/api/docs")
                .hasRole("ADMIN")
                // 失败跳转登陆表单
                .and().httpBasic().and().formLogin()
                // 关闭cls校验
                .permitAll().and().csrf().disable();
    }
}
