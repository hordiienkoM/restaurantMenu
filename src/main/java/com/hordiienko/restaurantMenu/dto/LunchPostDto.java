package com.hordiienko.restaurantMenu.dto;

import com.hordiienko.restaurantMenu.entity.Cuisine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LunchPostDto {
    private String name;
    private Long cuisineId;
    private Long mainCourseId;
    private Long dessertId;
}
