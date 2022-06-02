package uz.azi.ecomproduct.product;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uz.azi.ecomproduct.product.entity.User;

@FeignClient(name = "product",  url = "${user-service.url}")
public interface ProductFeignClient {

    @GetMapping("/get/{userId}")
    User getUser(@PathVariable Long userId);

}
