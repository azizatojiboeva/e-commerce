package uz.azi.ecomproduct.product;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.azi.ecomproduct.product.dto.ProductCreateDto;
import uz.azi.ecomproduct.product.dto.ProductDto;
import uz.azi.ecomproduct.product.dto.ProductUpdateDto;
import uz.azi.ecomproduct.product.entity.Product;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public abstract class ProductMapper {
    public abstract List<ProductDto> toDto(List<Product> entities);

    public abstract Product fromCreateDto(ProductCreateDto createDto);

    public abstract Product fromUpdateDto(ProductUpdateDto updateDto);

    public abstract ProductDto toDto(Product entity);
}