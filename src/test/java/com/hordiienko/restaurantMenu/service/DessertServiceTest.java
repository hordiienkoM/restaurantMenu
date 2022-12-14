package com.hordiienko.restaurantMenu.service;

import com.hordiienko.restaurantMenu.dto.DessertPostDto;
import com.hordiienko.restaurantMenu.entity.*;
import com.hordiienko.restaurantMenu.repository.CuisineRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DessertServiceTest {
    @InjectMocks
    private DessertService mockDessertService;
    @Mock
    private CuisineRepository mockCuisineRepository;
    private DessertPostDto dessertInfo;

    private Cuisine trueCuisine;

    private Dessert trueDesert;


    @Before
    public void addFields() {
        dessertInfo = new DessertPostDto();
        dessertInfo.setName("Dessert");
        dessertInfo.setPrice(20.8);
        dessertInfo.setCuisineId(1L);

        trueCuisine = new Cuisine();
        trueCuisine.setName("Japan");
        trueCuisine.setId(1L);

        trueDesert = new Dessert();
        trueDesert.setName("Dessert");
        trueDesert.setPrice(20.8);
        trueDesert.setCuisine(trueCuisine);
    }

    @Test
    public void setInfoTest() {
        Long cuisineId = dessertInfo.getCuisineId();
        when(mockCuisineRepository.findById(cuisineId)).thenReturn(Optional.of(trueCuisine));

        Dessert dessert = new Dessert();
        mockDessertService.setDessertInfo(dessert, dessertInfo);
        assertEquals(dessert, trueDesert);
    }
}
