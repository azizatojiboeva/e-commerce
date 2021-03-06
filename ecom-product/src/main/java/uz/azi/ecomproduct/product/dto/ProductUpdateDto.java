package uz.azi.ecomproduct.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProductUpdateDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer count;
}
