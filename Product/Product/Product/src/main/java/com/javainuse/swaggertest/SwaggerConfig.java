package com.javainuse.swaggertest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket getsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("product-api")
				.apiInfo(apiInfo()).select().paths(getPaths()).build();
	}
	
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("product-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}
	
	public Docket putsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("product-api")
				.apiInfo(apiInfo()).select().paths(putPaths()).build();
	}
	
	public Docket deleteApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("product-api")
				.apiInfo(apiInfo()).select().paths(deletePaths()).build();
	}
		
	private Predicate<String> getPaths() {
		return or(regex("/Product/posts.*"), regex("/Product/id.*"));
	}
	
	private Predicate<String> postPaths() {
		return or(regex("/Product/posts.*"), regex("/Product.*"));
	}
	
	private Predicate<String> putPaths() {
		return or(regex("/Product/posts.*"), regex("/Product.*"));
	}
	
	private Predicate<String> deletePaths() {
		return or(regex("/Product/posts.*"), regex("/Product.*"));
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Product")
				.description("Product API")
				.termsOfServiceUrl("http://javainuse.com")
				.version("1.0").build();
	}

}