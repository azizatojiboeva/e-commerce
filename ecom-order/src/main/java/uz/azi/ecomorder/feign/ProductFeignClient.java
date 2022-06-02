package uz.azi.ecomorder.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "ecom-product-client")
public interface ProductFeignClient {

    @RequestMapping(value = "/product/checkCount/{productId}")
    boolean checkQuantity(@PathVariable(name = "productId") Long productId, int quantity);



}
