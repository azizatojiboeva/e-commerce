package uz.azi.ecomusers.dtos;

import lombok.*;

import javax.validation.constraints.Null;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateDto {

    private Long id;

    private String fullName;

    private String username;

    private String password;

    private String billingAddress;

    private String shippingAddress;
}
