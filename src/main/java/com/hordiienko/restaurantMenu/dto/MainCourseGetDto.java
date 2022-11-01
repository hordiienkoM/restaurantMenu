package com.hordiienko.restaurantMenu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainCourseGetDto {
    private Long id;
    private String name;
    private Double price;
    private CuisineGetDto cuisine;
}
