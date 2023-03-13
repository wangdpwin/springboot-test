package cn.wangdpwin.validator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author wangdongpeng
 * @Date 2023/3/13 18:52
 * @Version 1.0
 */

@Configuration
@EnableOpenApi
// @EnableKnife4j
// @EnableSwagger2
public class Knife4jConfig {
    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.OAS_30)
                .apiInfo(new ApiInfoBuilder()
                        .title("我的标题")
                        .description("我的描述")
                        // .termsOfServiceUrl("http://www.xx.com/")
                        .contact(new Contact("knife", "https://knife.blog.csdn.net/", "xx@qq.com"))
                        .version("1.0")
                        .build())
                // 分组名称
                .groupName("all")
                .select()
                // 这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("cn.wangdpwin.validator"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }
}
