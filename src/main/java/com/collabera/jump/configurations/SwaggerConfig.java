package com.collabera.jump.configurations;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket employeeApi() {
//		Predicate<RequestHandler> selector = RequestHandlerSelectors.basePackage("com.collabera.jump");
//		
//		Predicate<String> pathselector = PathSelectors.ant("/employee/**");
		
		Docket docket = new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.collabera.jump")).build();
		
		Collection<VendorExtension> extensions = new ArrayList<>();
		Contact contact = new Contact("Justin Reed", "https://www.linkedin.com/in/justin-reed-03aa20bb/", "justin.reed006@gmail.com");
		ApiInfo apiInfo = new ApiInfo("Employee Api", "This API is designed to create and maintain employees using CRUD Operations, please familiarize yourself with the models before attempting to creating your first employee.. Enjoy!", "1.0.0", "https://www.termsfeed.com/terms-service/33c99a1f73f5a48a4ab1d23da987abcb", contact, "license", "http://www.apache.org/licenses/LICENSE-2.0", extensions);
		
		docket.apiInfo(apiInfo).useDefaultResponseMessages(false);
		return docket;
		
	}
}
