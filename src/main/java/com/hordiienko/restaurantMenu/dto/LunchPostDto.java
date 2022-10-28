package com.hordiienko.restaurantMenu.dto;

import com.hordiienko.restaurantMenu.entity.Cuisine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LunchPostDto {
    private Cuisine cuisine;
    private Long mainCourseId;
    private Long desertId;
}
