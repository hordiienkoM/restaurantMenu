package com.hordiienko.restaurantMenu.mapper;

import com.hordiienko.restaurantMenu.dto.DrinkAdditiveGetDto;
import com.hordiienko.restaurantMenu.entity.DrinkAdditive;
import org.mapstruct.Mapper;

@Mapper
public interface DrinkAdditiveMapper {
    DrinkAdditiveGetDto toGetDto(DrinkAdditive drinkAdditive);
}
