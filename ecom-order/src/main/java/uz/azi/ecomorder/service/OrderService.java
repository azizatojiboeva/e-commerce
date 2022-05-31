package uz.azi.ecomorder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.azi.ecomorder.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final OrderRepository repository;
}
