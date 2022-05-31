package uz.azi.ecomorder.dtos;

import lombok.*;
import uz.azi.ecomorder.enums.OrderStatus;
import uz.azi.ecomorder.model.SoldProduct;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderCreateDto {

    private OrderStatus status;

    @Column(name = "user_id")
    private Long userId;

    private int quantity;

    private List<SoldProduct> products = new ArrayList<>(0);


}
