package uz.azi.ecomusers.dtos;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateDto {

    private String fullName;

    private String username;

    private String password;

    private String billingAddress;

    private String shippingAddress;

}
