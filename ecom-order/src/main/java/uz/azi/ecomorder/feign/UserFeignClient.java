package uz.azi.ecomorder.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uz.azi.ecomorder.dtos.UserDto;

@FeignClient(name = "ecom-users-client")
public interface UserFeignClient {

    @GetMapping(value = "/ecomuser/user/get/{id}")
    UserDto getOne(@PathVariable(name = "id") Long id);


}
