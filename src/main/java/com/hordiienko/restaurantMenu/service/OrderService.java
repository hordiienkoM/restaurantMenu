package com.hordiienko.restaurantMenu.service;

import com.hordiienko.restaurantMenu.dto.DrinkAdditiveOrderPostDto;
import com.hordiienko.restaurantMenu.dto.order_dto.OrderPostDto;
import com.hordiienko.restaurantMenu.dto.order_dto.OrderPutDto;
import com.hordiienko.restaurantMenu.dto.order_dto.abstract_dto.OrderInfo;
import com.hordiienko.restaurantMenu.entity.Drink;
import com.hordiienko.restaurantMenu.entity.DrinkAdditiveOrder;
import com.hordiienko.restaurantMenu.entity.Lunch;
import com.hordiienko.restaurantMenu.entity.Order;
import com.hordiienko.restaurantMenu.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private LunchRepository lunchRepository;
    @Autowired
    private DrinkRepository drinkRepository;
    @Autowired
    private DrinkAdditiveRepository additiveRepository;
    @Autowired
    private OrderRepository orderRepository;
    public Order saveNew(OrderPostDto orderInfo) {
        Order order = new Order();
        if(orderInfo.getLunchId() != null) {
            saveLunch(order, orderInfo);
        }
        if(orderInfo.getDrinkId() != null) {
            saveDrink(order, orderInfo);
        }
        if(orderInfo.getDrinkAdditiveOrders() != null) {
            saveDrinkAdditives(order, orderInfo);
        }
        return orderRepository.save(order);
    }

    public Order update(OrderInfo newInfo) {
        OrderPutDto orderPutDto = (OrderPutDto)newInfo;
        Order order = orderRepository.findById(orderPutDto.getId()).orElseThrow();
        saveLunch(order, orderPutDto);
        saveDrink(order, orderPutDto);
        saveDrinkAdditives(order, orderPutDto);
        return orderRepository.save(order);
    }

    private void saveLunch(Order order, OrderInfo orderInfo) {
        Long lunchId = orderInfo.getLunchId();
        Lunch lunch = lunchRepository.findById(lunchId).orElseThrow();
        order.setLunch(lunch);
    }

    private void saveDrink(Order order, OrderInfo orderInfo) {
        Long drinkId = orderInfo.getDrinkId();
        Drink drink = drinkRepository.findById(drinkId).orElseThrow();
        order.setDrink(drink);
    }

    private void saveDrinkAdditives(Order order, OrderInfo orderInfo) {
        Set<DrinkAdditiveOrderPostDto> additivesInfo = orderInfo.getDrinkAdditiveOrders();
        Set<DrinkAdditiveOrder> additives = additivesInfo.stream()
                .map(e -> {
                    DrinkAdditiveOrder additiveOrder = new DrinkAdditiveOrder();
                    additiveOrder.setDrinkAdditive(
                            additiveRepository.findById(e.getDrinkAdditiveId()).orElseThrow()
                    );
                    additiveOrder.setAmount(e.getAmount());
                    additiveOrder.setOrder(order);
                    return additiveOrder;
                }).collect(Collectors.toSet());
        order.setDrinkAdditiveOrders(additives);
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow();
    }
}
