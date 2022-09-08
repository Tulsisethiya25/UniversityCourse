 package com.uc.universitycourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2

public class UniversitycourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversitycourseApplication.class, args);
	}
    	@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any())
	         .apis(RequestHandlerSelectors.basePackage("com.uc.universitycourse.controller")).build().apiInfo(apiInfo());
	   }
	
	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() 
	{
		return new ApiInfoBuilder().title("University Courses Selection").description("this App useful for students as well as professors").termsOfServiceUrl("http://godknows.com").contact("tulsisethiya25@gmail.com").license("My License").licenseUrl("harshika.vanamoju.com").version("1.0").build();
		}

}



