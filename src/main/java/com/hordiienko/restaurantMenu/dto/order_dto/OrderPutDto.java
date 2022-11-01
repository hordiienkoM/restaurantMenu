package com.hordiienko.restaurantMenu.dto.order_dto;

import com.hordiienko.restaurantMenu.dto.DrinkAdditiveOrderPostDto;
import com.hordiienko.restaurantMenu.dto.order_dto.abstract_dto.OrderInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPutDto implements OrderInfo {
    private Long id;
    private Long lunchId;
    private Long drinkId;
    Set<DrinkAdditiveOrderPostDto> drinkAdditiveOrders;
}
