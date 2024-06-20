package unfv.edu.pe.swagger;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean //Objeto que es contenido en el framework
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.build();
	}
	
	private ApiKey apiKey() {
		return new ApiKey("Seguridad JWT", "Authorization", "header");
	}
	
	private List<SecurityReference> listadoSeguridad(){
		AuthorizationScope objAuthorizationScope = 
				new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] arrayAuthorizationScopes =
				new AuthorizationScope[1];
		arrayAuthorizationScopes[0] = objAuthorizationScope;
		return Arrays.asList(new SecurityReference("JWT", arrayAuthorizationScopes));
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(listadoSeguridad()).build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo(
				"API REST - QBO Institute", 
				"Api Rest para el curso de Spring Boot", 
				"1.0", 
				"Terminos y condiciones del autor", 
				new Contact("1111", "2222", "3333"), 
				"Licencia Libre", 
				"API Licencia QBO", 
				Collections.emptyList());
	}
}
