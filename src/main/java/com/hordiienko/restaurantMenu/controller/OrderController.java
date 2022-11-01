package com.hordiienko.restaurantMenu.controller;

import com.hordiienko.restaurantMenu.dto.order_dto.ComplexOrderGetDto;
import com.hordiienko.restaurantMenu.dto.order_dto.OrderPostDto;
import com.hordiienko.restaurantMenu.dto.order_dto.OrderPutDto;
import com.hordiienko.restaurantMenu.dto.order_dto.abstract_dto.AbstractOrderGetDto;
import com.hordiienko.restaurantMenu.entity.Order;
import com.hordiienko.restaurantMenu.mapper.OrderMapper;
import com.hordiienko.restaurantMenu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderMapper orderMapper;

    @PostMapping
    public AbstractOrderGetDto saveNew(@RequestBody OrderPostDto newOrder) {
        Order order = orderService.saveNew(newOrder);
        return orderMapper.toRegulateOrders(order);
    }

    @DeleteMapping
    public String deleteById(@RequestParam Long id) {
        orderService.deleteById(id);
        return "Order was deleted";
    }

    @PutMapping
    public ComplexOrderGetDto updateDrink(@RequestBody OrderPutDto newInfo) {
        Order order = orderService.update(newInfo);
        return orderMapper.toComplexGetDto(order);
    }

    @GetMapping
    public ComplexOrderGetDto getById(@RequestParam Long id) {
        Order order = orderService.getById(id);
        return orderMapper.toComplexGetDto(order);
    }

}
