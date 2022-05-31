package uz.azi.ecomorder;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition
public class EcomOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcomOrderApplication.class, args);
    }

}
