package uz.azi.ecomproduct.product;

import org.springframework.web.bind.annotation.*;
import uz.azi.ecomproduct.product.dto.ProductCreateDto;
import uz.azi.ecomproduct.product.dto.ProductDto;
import uz.azi.ecomproduct.product.dto.ProductUpdateDto;

import java.util.List;

@RestController("/product/")
public record ProductController(ProductService service) {

    @PostMapping(value = "create")
    public Long create(@RequestBody ProductCreateDto productPlanCreateDto) {
        return service.create(productPlanCreateDto);
    }

    @PostMapping(value = "update")
    public Boolean update(@RequestBody ProductUpdateDto productPlanUpdateDto) {
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

   /* @GetMapping(value = "list/{agentId}")
    public List<ProductDto> getAllByAgentId(@PathVariable("agentId") Long agentId) {
        return service.getAllByAgentId(agentId);
    }*/
}
