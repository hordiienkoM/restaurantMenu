package com.hordiienko.restaurantMenu.dto;

import com.hordiienko.restaurantMenu.entity.Cuisine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainCoursePostDto {
    private String name;
    private Double price;
    private Cuisine cuisine;
}
