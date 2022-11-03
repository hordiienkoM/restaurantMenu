package com.hordiienko.restaurantMenu.mapper;

import com.hordiienko.restaurantMenu.dto.DrinkAdditiveGetDto;
import com.hordiienko.restaurantMenu.entity.Dessert;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper
public interface DessertMapper {
    DrinkAdditiveGetDto.DessertGetDto toGetDto(Dessert dessert);

    Set<DrinkAdditiveGetDto.DessertGetDto> toGetDtos(Set<Dessert> desserts);
}
