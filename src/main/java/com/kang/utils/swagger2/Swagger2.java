package com.kang.utils.swagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author dyt
 * @ClassName org.spring.springboot
 * @Description
 * @date 2019-03-10 22:12:31
 */
//通过@Configuration注解，让Spring-boot来加载该类配置。再通过@EnableSwagger2注解来启用
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
//				当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.kang.*.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("springboot利用swagger构建api文档测试项目")
                //描述
                .description("本工程的总体建设目标是通过实现站务系统功能改造和完善，规范客运站和运输公司等客运企业经营管理行为，提高其运行效率，提升公众出行服务效能。")
                //版本号
                .version("1.0")
                .build();
    }
}
