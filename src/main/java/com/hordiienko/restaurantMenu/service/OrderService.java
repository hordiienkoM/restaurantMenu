package com.hordiienko.restaurantMenu.service;

import com.hordiienko.restaurantMenu.dto.DrinkAdditiveOrderPostDto;
import com.hordiienko.restaurantMenu.dto.order_dto.OrderPostDto;
import com.hordiienko.restaurantMenu.dto.order_dto.OrderPutDto;
import com.hordiienko.restaurantMenu.dto.info_parent.OrderInfo;
import com.hordiienko.restaurantMenu.entity.*;
import com.hordiienko.restaurantMenu.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private LunchRepository lunchRepository;
    @Autowired
    private DrinkRepository drinkRepository;
    @Autowired
    private DrinkAdditiveService drinkAdditiveService;
    @Autowired
    private OrderRepository orderRepository;

    public Order save(OrderPostDto orderInfo) {
        Order order = setInfo(orderInfo);
        return orderRepository.save(order);
    }

    public Order update(OrderPutDto orderPutDto) {
        Order order = setInfo(orderPutDto);
        order.setId(orderPutDto.getId());
        return orderRepository.save(order);
    }

    protected Order setInfo(OrderInfo orderInfo) {
        if (orderInfo.getLunchId() == null && orderInfo.getDrinkId() == null) {
            throw new RuntimeException("The order must be not empty");
        }
        Order order = new Order();
        if (orderInfo.getLunchId() != null) {
            saveLunch(order, orderInfo);
        }
        if (orderInfo.getDrinkId() != null) {
            saveDrink(order, orderInfo);
        }
        if (orderInfo.getDrinkAdditiveOrders() != null) {
            saveDrinkAdditives(order, orderInfo);
        }
        return order;
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

    protected void saveDrinkAdditives(Order order, OrderInfo orderInfo) {
        Map<Long, DrinkAdditive> drinkAdditiveMap = drinkAdditiveService.getAllAdditives();
        Set<DrinkAdditiveOrderPostDto> additivesInfo = orderInfo.getDrinkAdditiveOrders();
        Set<DrinkAdditiveOrder> additives = additivesInfo.stream()
                .map(e -> {
                    DrinkAdditiveOrder additiveOrder = new DrinkAdditiveOrder();
                    additiveOrder.setDrinkAdditive(
                            drinkAdditiveMap.get(e.getDrinkAdditiveId())
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
