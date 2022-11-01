package com.hordiienko.restaurantMenu.dto.order_dto;

import com.hordiienko.restaurantMenu.dto.DrinkAdditiveOrderGetDto;
import com.hordiienko.restaurantMenu.dto.order_dto.abstract_dto.AbstractOrderGetDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderComplexDrinkGetDto extends AbstractOrderGetDto {
    private Long id;
    private String drinkName;
    private Set<DrinkAdditiveOrderGetDto> drinkAdditiveOrders;
}
