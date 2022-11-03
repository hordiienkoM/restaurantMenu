package com.hordiienko.restaurantMenu.mapper;

import com.hordiienko.restaurantMenu.dto.order_dto.*;
import com.hordiienko.restaurantMenu.dto.info_parent.AbstractOrderGetDto;
import com.hordiienko.restaurantMenu.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper
public interface OrderMapper {
    default AbstractOrderGetDto toRegulateOrders(Order order) {
        boolean hasLunch = (order.getLunch() != null);
        boolean hasDrink = (order.getDrink() != null);
        boolean hasAdditive = (order.getDrinkAdditiveOrders() != null);
        if (hasLunch && hasDrink && hasAdditive) {
            return toComplexGetDto(order);
        } else if (hasLunch && hasDrink) {
            return toLunchDrinkGetDto(order);
        } else if (hasLunch) {
            return toJustLunchGetDto(order);
        } else if (hasDrink && hasAdditive) {
            return toComplexDrinkGetDto(order);
        } else {
            return toJustDrinkGetDto(order);
        }
    }

    @Mapping(expression = "java(order.getLunch().getName())", target = "lunchName")
    @Mapping(expression = "java(order.getDrink().getName())", target = "drinkName")
    ComplexOrderGetDto toComplexGetDto(Order order);

    @Mapping(expression = "java(order.getLunch().getName())", target = "lunchName")
    @Mapping(expression = "java(order.getDrink().getName())", target = "drinkName")
    OrderLunchDrinkGetDto toLunchDrinkGetDto(Order order);

    @Mapping(expression = "java(order.getDrink().getName())", target = "drinkName")
    OrderComplexDrinkGetDto toComplexDrinkGetDto(Order order);

    @Mapping(expression = "java(order.getDrink().getName())", target = "drinkName")
    OrderJustDrinkGetDto toJustDrinkGetDto(Order order);

    @Mapping(expression = "java(order.getLunch().getName())", target = "lunchName")
    OrderJustLunchGetDto toJustLunchGetDto(Order order);



    Set<ComplexOrderGetDto> toGetDtos(Set<Order> orders);
}
