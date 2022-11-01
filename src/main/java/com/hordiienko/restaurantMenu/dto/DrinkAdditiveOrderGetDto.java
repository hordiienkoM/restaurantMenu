package com.hordiienko.restaurantMenu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrinkAdditiveOrderGetDto {
    private DrinkAdditiveGetDto drinkAdditive;
    private int amount;
}
