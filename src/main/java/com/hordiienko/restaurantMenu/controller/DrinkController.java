package com.hordiienko.restaurantMenu.controller;

import com.hordiienko.restaurantMenu.dto.DrinkGetDto;
import com.hordiienko.restaurantMenu.dto.DrinkPostDto;
import com.hordiienko.restaurantMenu.dto.DrinkPutDto;
import com.hordiienko.restaurantMenu.entity.Drink;
import com.hordiienko.restaurantMenu.mapper.DrinkMapper;
import com.hordiienko.restaurantMenu.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/v1/drinks")
public class DrinkController {
    @Autowired
    private DrinkService drinkService;
    @Autowired
    private DrinkMapper drinkMapper;

    @PostMapping
    public DrinkGetDto saveNew(@RequestBody DrinkPostDto newDrink) {
        Drink drink = drinkService.save(newDrink);
        return drinkMapper.toGetDto(drink);
    }

    @DeleteMapping
    public String deleteById(@RequestParam Long id) {
        drinkService.deleteById(id);
        return "Drink was deleted";
    }

    @PutMapping
    public DrinkGetDto updateDrink(@RequestBody DrinkPutDto newInfo) {
        Drink drink = drinkService.update(newInfo);
        return drinkMapper.toGetDto(drink);
    }

    @GetMapping
    public DrinkGetDto getById(@RequestParam Long id) {
        Drink drink = drinkService.getById(id);
        return drinkMapper.toGetDto(drink);
    }

    @GetMapping("/all_by_cuisine")
    public Set<DrinkGetDto> getAllByCuisine(@RequestParam Long cuisineId) {
        Set<Drink> drinks = drinkService.getAllByCousine(cuisineId);
        return drinkMapper.toGetDtos(drinks);
    }
}
