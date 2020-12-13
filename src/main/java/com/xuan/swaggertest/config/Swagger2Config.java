package com.xuan.swaggertest.config;

import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2//开启swagger2
public class Swagger2Config {

//    @Bean
//    public Docket docket1(){
//        return new Docket(DocumentationType.SWAGGER_2).groupName("test2");
//    }
    @Bean
    public Docket docket(Environment environment){
        Profiles profiles = Profiles.of("dev","test");
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiInfo()).
                //是否启动Swagger
                enable(flag).
                groupName("test1").
                select().
                apis(RequestHandlerSelectors.basePackage("com.xuan.swaggertest.controller")).
                //paths(PathSelectors.ant("/**/hello")).
                build();
    }

    public ApiInfo apiInfo(){
        Contact contact = new Contact("xuan","uuu","xuan@126.com");
        return new ApiInfo("Swagger-test",
                "test",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
