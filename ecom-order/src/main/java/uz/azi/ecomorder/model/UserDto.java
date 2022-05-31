package uz.azi.ecomorder.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;

    private String fullName;

    private String username;

    private String password;

    private String billingAddress;

    private String shippingAddress;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;


}
