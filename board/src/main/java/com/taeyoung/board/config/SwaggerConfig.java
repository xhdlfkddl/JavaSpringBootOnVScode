package com.taeyoung.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                    .title("Young's board REST API")
                    .description("Spring boot로 작성한 REST API 명세서")
                    .version("1.0.0")
                    .build();

    }

    @Bean
    protected Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                            .apiInfo(apiInfo())
                            .select()
                            .apis(RequestHandlerSelectors.any())
                            .paths(PathSelectors.any())
                            .build();
    }
    

}
