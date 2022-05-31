package uz.azi.ecomproduct.product.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProductDto {
    private String name;
    private String description;
    private Double price;
    private Integer count;
}
