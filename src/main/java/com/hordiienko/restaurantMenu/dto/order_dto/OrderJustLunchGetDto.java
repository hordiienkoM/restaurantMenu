package com.hordiienko.restaurantMenu.dto.order_dto;

import com.hordiienko.restaurantMenu.dto.info_parent.AbstractOrderGetDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderJustLunchGetDto extends AbstractOrderGetDto {
    private Long id;
    private String lunchName;
}
