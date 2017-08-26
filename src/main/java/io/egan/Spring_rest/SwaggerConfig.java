package io.egan.Spring_rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

//	@Bean
//	public Docket api(){
//		return new Docket(DocumentationType.SWAGGER_2).pathMapping("/api/*").apiInfo(apiInfo());
//	}
//	
//	private ApiInfo apiInfo(){
//		Contact contact = new Contact("Simran", "github.com/sainisimr", "saini.simranjeet@gmail.com");
//		ApiInfo apinfo = new ApiInfo("Spring-Rest", "A simple Rest Api", "1.0.0", "TNC", contact, "MIT", "meettreet.com");
//		return apinfo;
//	}
//	
}
