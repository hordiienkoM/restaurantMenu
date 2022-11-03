package com.hordiienko.restaurantMenu.mapper;

import com.hordiienko.restaurantMenu.dto.DessertGetDto;
import com.hordiienko.restaurantMenu.entity.Dessert;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper
public interface DessertMapper {
    DessertGetDto toGetDto(Dessert dessert);

    Set<DessertGetDto> toGetDtos(Set<Dessert> desserts);
}
