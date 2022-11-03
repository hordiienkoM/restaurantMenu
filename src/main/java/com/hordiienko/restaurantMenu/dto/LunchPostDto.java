package com.hordiienko.restaurantMenu.dto;

import com.hordiienko.restaurantMenu.dto.info_parent.LunchInfo;
import com.hordiienko.restaurantMenu.entity.Cuisine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LunchPostDto implements LunchInfo {
    private String name;
    private Long cuisineId;
    private Long mainCourseId;
    private Long dessertId;
}
