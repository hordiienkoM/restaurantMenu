package com.hordiienko.restaurantMenu.dto.order_dto;

import com.hordiienko.restaurantMenu.dto.order_dto.abstract_dto.AbstractOrderGetDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderJustDrinkGetDto extends AbstractOrderGetDto {
    private Long id;
    private String drinkName;
}
