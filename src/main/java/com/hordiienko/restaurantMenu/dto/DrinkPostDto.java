package com.hordiienko.restaurantMenu.dto;

import com.hordiienko.restaurantMenu.dto.info_parent.DrinkInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DrinkPostDto implements DrinkInfo {
    private String name;
    private Double price;
    private Long cuisineId;
}
