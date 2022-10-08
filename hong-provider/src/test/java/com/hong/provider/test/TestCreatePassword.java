package com.hong.provider.test;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  11:03 2022/10/8
 */
public class TestCreatePassword {

    public static void main (String[] args) {
        String henley = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("henley");
        System.out.println(henley);
    }
}
