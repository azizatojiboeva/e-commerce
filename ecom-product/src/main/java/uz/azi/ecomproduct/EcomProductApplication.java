package uz.azi.ecomproduct;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition
public class EcomProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcomProductApplication.class, args);
    }

}
