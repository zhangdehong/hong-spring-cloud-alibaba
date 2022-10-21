package com.hong.provider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * swagger 配置类
 *
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  14:02 2022/10/6
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    public ApiInfo getApiInfo () {
        return new ApiInfoBuilder().title("【部门微服务】示例")
                .description("实现部门数据的统一管理,包括：增加部门信息、查询部门信息、部门列表展示等。")
                .termsOfServiceUrl("https://henley.com")
                .contact(new Contact("晴天", "study.henley.com", "835981218@qq.com"))
                .license("晴天学习室-授权管理")
                .version("1.0.0")
                .build();
    }

    // @Override
    // public void addResourceHandlers (ResourceHandlerRegistry registry) {
    //     registry.addResourceHandler("/swagger-ui/**")
    //             .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
    // }

    @Bean
    public Docket getDocket () {
        // 使用的文档版本类型
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(this.getApiInfo())
                // 所有的接口一定放在指定的包中
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hong.provider.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
