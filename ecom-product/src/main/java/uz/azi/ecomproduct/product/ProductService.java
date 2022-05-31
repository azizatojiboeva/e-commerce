package uz.azi.ecomproduct.product;

import org.springframework.stereotype.Service;
import uz.azi.ecomproduct.product.dto.ProductCreateDto;
import uz.azi.ecomproduct.product.dto.ProductDto;
import uz.azi.ecomproduct.product.dto.ProductUpdateDto;
import uz.azi.ecomproduct.product.entity.Product;
import uz.azi.ecomproduct.product.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public record ProductService(ProductMapper mapper, ProductRepository repository,ProductFeignClient client) {

    public Long create(ProductCreateDto createDto) {
        if (Objects.isNull(createDto)) throw new RuntimeException("Bad Request");
        Optional<Product> byName = repository.findByName(createDto.getName());
        if (byName.isPresent()) throw new RuntimeException("Already Exist");
        Product product = mapper.fromCreateDto(createDto);
        return repository.save(product).getId();
    }


    public Void delete(Long id) {
        if (Objects.isNull(id)) throw new RuntimeException("Bad Request");
        Optional<Product> byName = repository.findById(id);
        if (byName.isEmpty()) throw new RuntimeException("Not found");
        repository.softDelete(id);
        return null;
    }


    public boolean update(ProductUpdateDto updateDto) {
        if (Objects.isNull(updateDto)) throw new RuntimeException("Bad Request");
        Optional<Product> byName = repository.findById(updateDto.getId());
        if (byName.isEmpty()) throw new RuntimeException("Not Found");
        Product product = mapper.fromUpdateDto(updateDto);
        repository.save(product);
        return true;
    }


    public ProductDto get(Long id) {
        if (Objects.isNull(id)) throw new RuntimeException("Bad Request");
        Optional<Product> byName = repository.findById(id);
        if (byName.isEmpty()) throw new RuntimeException("Not found");
        return mapper.toDto(byName.get());
    }


    public List<ProductDto> getAll() {
        List<Product> all = repository.findAll();
        if (all.isEmpty()) throw new RuntimeException("Not exist yet");
        return mapper.toDto(all);
    }

    public List<ProductDto> getAll(Long id) {
        if (Objects.isNull(id)) throw new RuntimeException("Bad Request");
        User user = client.getUser(id);
        if (Objects.isNull(user)) throw new RuntimeException("Not found user");
        List<Product> allByUserId = repository.findAllByUserId(id);
        if (allByUserId.isEmpty()) throw new RuntimeException("This user not create product");
        return mapper.toDto(allByUserId);
    }


}
