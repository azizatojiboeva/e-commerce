package uz.azi.ecomorder.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.azi.ecomorder.service.OrderService;

@RestController
@RequestMapping(value = "/ecomorder/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;










}
