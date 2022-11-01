package com.hordiienko.restaurantMenu.dto;

import com.hordiienko.restaurantMenu.dto.CuisineGetDto;
import com.hordiienko.restaurantMenu.dto.DessertGetDto;
import com.hordiienko.restaurantMenu.dto.MainCourseGetDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LunchGetDto {
    private Long id;
    private String name;
    private CuisineGetDto cuisine;
    private MainCourseGetDto mainCourse;
    private DessertGetDto dessert;
}
