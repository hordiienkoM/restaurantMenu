package com.hordiienko.restaurantMenu.dto;

import com.hordiienko.restaurantMenu.dto.info_parent.MainCourseInfo;
import com.hordiienko.restaurantMenu.entity.Cuisine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainCoursePostDto implements MainCourseInfo {
    private String name;
    private Double price;
    private Long cuisineId;
}
