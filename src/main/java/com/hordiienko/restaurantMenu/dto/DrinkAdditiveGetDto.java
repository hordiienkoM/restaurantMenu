package com.hordiienko.restaurantMenu.dto;

import com.hordiienko.restaurantMenu.dto.info_parent.DessertInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrinkAdditiveGetDto {
    private Long id;
    private String name;
    private Double price;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DessertGetDto {
        private Long id;
        private String name;
        private Double price;
        private CuisineGetDto cuisine;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DessertPostDto implements DessertInfo {
        private String name;
        private Double price;
        private Long cuisineId;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DessertPutDto implements DessertInfo {
        private Long id;
        private String name;
        private Double price;
        private Long cuisineId;
    }
}
