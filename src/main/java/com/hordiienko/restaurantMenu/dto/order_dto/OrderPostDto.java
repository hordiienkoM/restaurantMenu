package com.hordiienko.restaurantMenu.dto.order_dto;

import com.hordiienko.restaurantMenu.dto.DrinkAdditiveOrderPostDto;
import com.hordiienko.restaurantMenu.dto.info_parent.OrderInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPostDto implements OrderInfo {
    private Long lunchId;
    private Long drinkId;
    Set<DrinkAdditiveOrderPostDto> drinkAdditiveOrders;
}
