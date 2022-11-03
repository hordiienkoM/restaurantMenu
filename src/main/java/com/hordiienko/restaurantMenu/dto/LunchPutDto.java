package com.hordiienko.restaurantMenu.dto;

import com.hordiienko.restaurantMenu.dto.info_parent.LunchInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LunchPutDto implements LunchInfo {
    private Long id;
    private String name;
    private Long cuisineId;
    private Long mainCourseId;
    private Long dessertId;
}
