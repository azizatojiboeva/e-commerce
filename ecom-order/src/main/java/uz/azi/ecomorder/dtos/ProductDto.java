package uz.azi.ecomorder.dtos;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private String name;
    private String description;
    private Double price;
    private Integer count;


}
