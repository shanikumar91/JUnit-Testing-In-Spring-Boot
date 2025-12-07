package com.springbootproject.productslist;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info=@Info(
                title = "Product Service REST API Documentation",
                description = "Product Service REST API",
                version = "v1",
                contact = @Contact(
                        name = "Shani kumar",
                        email = "shanikumar87915688@gmail.com"
                )

        ),
        externalDocs = @ExternalDocumentation(
                description = "Sharepoint URL Product Service API",
                url = "example.com"
        )
)

@SpringBootApplication
@Slf4j // for logging annotation
public class ProductsListApplication {
//    private static final Logger log = LoggerFactory.getLogger(ProductsListApplication.class);
	public static void main(String[] args) {
        SpringApplication.run(ProductsListApplication.class, args);
        System.out.println("Hare krishna hare  Krishna");
        String str = "test";
        log.info("Product Service started {} successfully",str);
        log.warn("This is a warning message");
        log.debug("This is a debug message");
        log.error("This is an error message");
        log.trace("This is a trace message");
	}

}
