package uz.azi.ecomorder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.azi.ecomorder.dtos.OrderCreateDto;
import uz.azi.ecomorder.dtos.OrderUpdateDTo;
import uz.azi.ecomorder.feign.ProductFeignClient;
import uz.azi.ecomorder.feign.UserFeignClient;
import uz.azi.ecomorder.mapper.OrderMapper;
import uz.azi.ecomorder.model.Order;
import uz.azi.ecomorder.model.SoldProduct;
import uz.azi.ecomorder.repository.OrderRepository;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;

    private final UserFeignClient userclient;
    private final ProductFeignClient productclient;

    public Long create(OrderCreateDto dto) {
        Order order = mapper.fromCreateDto(dto);
        checkIfProductExist(order.getProducts());
        checkUserExist(order.getUserId());
        repository.save(order);
        return order.getId();
    }

    private void checkUserExist(Long userId) {
        if (Objects.isNull(userclient.getOne(userId))) {
            throw new RuntimeException("User not found!");
        }
    }

    private void checkIfProductExist(List<SoldProduct> products) {
        products.forEach(
                product -> checkQuantity(product.getProductId(), product.getCount()));
    }

    private void checkQuantity(Long productId, int count) {
        boolean res = productclient.checkQuantity(productId, count);
        if (!res) {
            throw new RuntimeException("Not enough quantity!");
        }
    }


    public Boolean update(OrderUpdateDTo dto) {
        Order order = mapper.fromUpdateDto(dto);
        repository.findById(order.getId()).orElseThrow(
                () -> {
                    throw new RuntimeException("Order not found");
                }
        );
        repository.save(order);
        return true;
    }


    public Void delete(Long id) {
        repository.findById(id).orElseThrow(
                () -> {
                    throw new RuntimeException("Order not found");
                }
        );
        repository.softDelete(id);
        return null;
    }


}
