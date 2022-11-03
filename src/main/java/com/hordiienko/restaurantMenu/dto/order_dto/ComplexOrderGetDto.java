package com.hordiienko.restaurantMenu.dto.order_dto;

import com.hordiienko.restaurantMenu.dto.DrinkAdditiveOrderGetDto;
import com.hordiienko.restaurantMenu.dto.info_parent.AbstractOrderGetDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplexOrderGetDto extends AbstractOrderGetDto {
    private Long id;
    private String lunchName;
    private String drinkName;
    private Set<DrinkAdditiveOrderGetDto> drinkAdditiveOrders;
}
