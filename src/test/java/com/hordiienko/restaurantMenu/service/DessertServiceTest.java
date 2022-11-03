package com.hordiienko.restaurantMenu.service;

import com.hordiienko.restaurantMenu.dto.DrinkAdditiveGetDto;
import com.hordiienko.restaurantMenu.dto.info_parent.DessertInfo;
import com.hordiienko.restaurantMenu.entity.*;
import com.hordiienko.restaurantMenu.repository.CuisineRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DessertServiceTest {
    @InjectMocks
    private DessertService mockDessertService;
    @Mock
    private CuisineRepository mockCuisineRepository;
//    @Test
//    public void setInfoTest() {
//        when(mockCuisineRepository.findById(1L)).thenReturn(Optional.of(new Cuisine()));
//
//        Dessert dessert = new Dessert();
//        DessertInfo dessertInfo = new DrinkAdditiveGetDto.DessertPostDto();
//
//        assertEquals(orderComplex, trueComplexOrder);
//        assertEquals(orderLunchDrink, trueLunchDrinkOrder);
//        assertEquals(orderComplexDrink, trueComplexDrinkOrder);
//        assertEquals(orderDrink, trueJustDrinkOrder);
//        assertEquals(orderLunch, trueJustLunchOrder);
//    }
//
//    protected void setDessertInfo (Dessert dessert, DessertInfo dessertInfo) {
//        Cuisine cuisine = cuisineRepository.findById(
//                dessertInfo.getCuisineId()
//        ).orElseThrow();
//        dessert.setName(dessertInfo.getName());
//        dessert.setPrice(dessertInfo.getPrice());
//        dessert.setCuisine(cuisine);
//    }
}
