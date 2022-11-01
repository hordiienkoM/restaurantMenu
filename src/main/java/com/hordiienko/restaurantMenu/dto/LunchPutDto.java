package com.hordiienko.restaurantMenu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LunchPutDto {
    private Long id;
    private String name;
    private Long cuisineId;
    private Long mainCourseId;
    private Long dessertId;
}
