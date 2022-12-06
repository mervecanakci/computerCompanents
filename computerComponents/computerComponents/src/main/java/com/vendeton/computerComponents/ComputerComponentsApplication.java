package com.vendeton.computerComponents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ComputerComponentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputerComponentsApplication.class, args);
	}

	 @Bean //java class ı demek ama genellikle konfigürasyon amaçlı kullanılır
	 //java bean ı görünce belleğe yerleştiriyor.
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.basePackage("com.vendeton.computerComponents"))              
	         // com.vendeton.computerComponents gez apileri bul dökümantasyona ekle                        
	          .build();                                           
	    }
	
	
}
