package com.hordiienko.restaurantMenu.mapper;

import com.hordiienko.restaurantMenu.dto.DrinkGetDto;
import com.hordiienko.restaurantMenu.entity.Drink;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper
public interface DrinkMapper {

    DrinkGetDto toGetDto(Drink drink);

    Set<DrinkGetDto> toGetDtos(Set<Drink> drinks);
}
