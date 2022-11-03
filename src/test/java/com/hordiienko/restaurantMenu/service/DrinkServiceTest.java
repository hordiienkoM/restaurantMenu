package com.hordiienko.restaurantMenu.service;

import com.hordiienko.restaurantMenu.dto.DrinkPostDto;
import com.hordiienko.restaurantMenu.entity.Cuisine;
import com.hordiienko.restaurantMenu.entity.Drink;
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
public class DrinkServiceTest {
    @InjectMocks
    private DrinkService mockDrinkService;
    @Mock
    private CuisineRepository mockCuisineRepository;
    private Cuisine trueCuisine;
    private DrinkPostDto drinkInfo;

    private Drink trueDrink;

    @Before
    public void addFields() {
        drinkInfo = new DrinkPostDto();
        drinkInfo.setCuisineId(1L);
        drinkInfo.setName("Tea");
        drinkInfo.setPrice(20.0);

        trueCuisine = new Cuisine();
        trueCuisine.setName("Japan");
        trueCuisine.setId(1L);

        trueDrink = new Drink();
        trueDrink.setCuisine(trueCuisine);
        trueDrink.setName("Tea");
        trueDrink.setPrice(20.0);
    }

    @Test
    public void saveInfoTest() {
        Long cuisineId = trueCuisine.getId();
        when(mockCuisineRepository.findById(cuisineId)).thenReturn(Optional.of(trueCuisine));

        Drink drink = new Drink();
        mockDrinkService.saveInfo(drink, drinkInfo);
        assertEquals(drink, trueDrink);
    }
}
