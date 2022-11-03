package com.hordiienko.restaurantMenu.dto;

import com.hordiienko.restaurantMenu.dto.info_parent.MainCourseInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainCoursePutDto implements MainCourseInfo {
    private Long id;
    private String name;
    private Double price;
    private Long cuisineId;
}
