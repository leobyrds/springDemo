package com.goopal.config.swagger2;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Created by leon on 2016/11/4.
 */
//@Configuration
//@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()   //// 选择那些路径和api会生成document
//                .apis(RequestHandlerSelectors.any()) // 对所有api进行监控
//                .paths(PathSelectors.any()) // 对所有路径进行监控
                .apis(RequestHandlerSelectors.basePackage("com.goopal.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建Restful Api")
                .description("更多Spring Boot相关文章请关注：http://www.baidu.com/")
                .termsOfServiceUrl("http://www.baidu.com/")
                .contact(new Contact("lipeng","","lipeng@new4g.cn"))
                .version("1.0")
                .build();
    }
}
