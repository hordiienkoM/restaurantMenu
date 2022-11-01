package com.hordiienko.restaurantMenu.dto.order_dto.abstract_dto;

import com.hordiienko.restaurantMenu.dto.DrinkAdditiveOrderPostDto;

import java.util.Set;

public interface OrderInfo {
    Long getLunchId();
    Long getDrinkId();
    Set<DrinkAdditiveOrderPostDto> getDrinkAdditiveOrders();
}
