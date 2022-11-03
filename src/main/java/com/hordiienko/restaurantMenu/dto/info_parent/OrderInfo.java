package com.hordiienko.restaurantMenu.dto.info_parent;

import com.hordiienko.restaurantMenu.dto.DrinkAdditiveOrderPostDto;

import java.util.Set;

public interface OrderInfo {
    Long getLunchId();

    Long getDrinkId();

    Set<DrinkAdditiveOrderPostDto> getDrinkAdditiveOrders();
}
