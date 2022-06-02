package uz.azi.ecomorder.mapper;


import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.azi.ecomorder.dtos.OrderCreateDto;
import uz.azi.ecomorder.dtos.OrderUpdateDTo;
import uz.azi.ecomorder.model.Order;

@Mapper(componentModel = "spring")
@Component
public interface OrderMapper {

    Order fromCreateDto(OrderCreateDto dto);


    Order fromUpdateDto(OrderUpdateDTo dto);
}
