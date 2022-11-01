package com.hordiienko.restaurantMenu.mapper;

import com.hordiienko.restaurantMenu.dto.LunchGetDto;
import com.hordiienko.restaurantMenu.entity.Lunch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper
public interface LunchMapper {
    @Mapping(source = "dessert", target = "dessert")
    LunchGetDto toGetDto(Lunch lunch);

    Set<LunchGetDto> toGetDtos(Set<Lunch> lunches);
}
