package com.hordiienko.restaurantMenu.mapper;

import com.hordiienko.restaurantMenu.dto.CuisineGetDto;
import com.hordiienko.restaurantMenu.entity.Cuisine;
import org.mapstruct.Mapper;

@Mapper
public interface CuisineMapper {
    CuisineGetDto toGetDto(Cuisine cuisine);
}
