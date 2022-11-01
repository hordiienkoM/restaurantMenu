package com.hordiienko.restaurantMenu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DrinkAdditiveOrderPostDto {
    private Long drinkAdditiveId;
    private int amount;
}
