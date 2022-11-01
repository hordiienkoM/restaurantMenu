package com.hordiienko.restaurantMenu.dto.order_dto;

import com.hordiienko.restaurantMenu.dto.order_dto.abstract_dto.AbstractOrderGetDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLunchDrinkGetDto extends AbstractOrderGetDto {
    private Long id;
    private String lunchName;
    private String drinkName;
}
