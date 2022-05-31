package uz.azi.ecomorder.dtos;

import lombok.*;
import uz.azi.ecomorder.enums.OrderStatus;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderUpdateDTo {
    private Long id;

    private OrderStatus status;

    private Long userId;

}
