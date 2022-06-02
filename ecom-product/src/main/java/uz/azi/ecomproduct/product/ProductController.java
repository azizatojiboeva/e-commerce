package uz.azi.ecomproduct.product;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;
import uz.azi.ecomproduct.product.dto.ProductCreateDto;
import uz.azi.ecomproduct.product.dto.ProductDto;
import uz.azi.ecomproduct.product.dto.ProductUpdateDto;

import java.util.List;

@RestController("/product/")
public record ProductController(ProductService service) {

    @GetMapping(value = "/checkCount/{id}")
    public boolean checkQuantity(@PathVariable(name = "id") Long id, @ParameterObject int count) {
        return service.checkCount(id, count);
    }


    @PostMapping(value = "create")
    public Long create(@RequestBody ProductCreateDto productPlanCreateDto) {
        return service.create(productPlanCreateDto);
    }

    @PostMapping(value = "update")
    public Void update(@RequestBody ProductUpdateDto productPlanUpdateDto) {
        return service.update(productPlanUpdateDto);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Void delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }

    @GetMapping(value = "{id}")
    public ProductDto get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @GetMapping(value = "")
    public List<ProductDto> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "list/{agentId}")
    public List<ProductDto> getAllByAgentId(@PathVariable("agentId") Long agentId) {
        return service.getAll(agentId);
    }
}
