package com.demo.web.config;

import com.google.common.collect.Lists;
import io.swagger.models.Swagger;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author peizhaohu
 */
@ConditionalOnClass(value = {Swagger.class})
@Configuration
@EnableSwagger2
@Profile(value = {"dev", "test"})
public class SwaggerConfig {

  @Value("${spring.application.name}")
  private String applicationName;

  @Bean
  public Docket createRestApi() {
    List<Parameter> parameters = Lists.newArrayList();
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.demo"))
        .paths(PathSelectors.any())
        .build().globalOperationParameters(parameters);
  }

  private ApiKey apiKey() {
    return new ApiKey("BearerToken", "pzh", "header");
  }


  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title(applicationName + "接口文档")
        .description(applicationName + "接口文档")
        .contact(new Contact("pzh", "http://www.miaoyouche.com", "mail.xxx@miaoyouche.com"))
        .version("1.0")
        .build();
  }

}
