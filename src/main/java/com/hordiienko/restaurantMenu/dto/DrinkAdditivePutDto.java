package com.hordiienko.restaurantMenu.dto;

import com.hordiienko.restaurantMenu.dto.info_parent.DrinkAdditiveInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrinkAdditivePutDto implements DrinkAdditiveInfo {
    private Long id;
    private String name;
    private Double price;
}
