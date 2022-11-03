package com.hordiienko.restaurantMenu.dto;

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
    private DrinkAdditiveGetDto.DessertGetDto dessert;
}
