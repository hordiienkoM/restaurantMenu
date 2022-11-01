package com.hordiienko.restaurantMenu.mapper;

import com.hordiienko.restaurantMenu.dto.DrinkAdditiveOrderGetDto;
import com.hordiienko.restaurantMenu.entity.DrinkAdditiveOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper
public interface DrinkAdditiveOrderMapper {
    DrinkAdditiveOrderGetDto toGetDto(DrinkAdditiveOrder additiveOrder);

    Set<DrinkAdditiveOrder> toGetDtos(Set<DrinkAdditiveOrder> drinkAdditiveOrders);
}
