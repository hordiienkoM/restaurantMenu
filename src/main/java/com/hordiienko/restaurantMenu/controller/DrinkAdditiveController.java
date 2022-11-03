package com.hordiienko.restaurantMenu.controller;

import com.hordiienko.restaurantMenu.dto.*;
import com.hordiienko.restaurantMenu.entity.DrinkAdditive;
import com.hordiienko.restaurantMenu.mapper.DrinkAdditiveMapper;
import com.hordiienko.restaurantMenu.service.DrinkAdditiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/drink_additives")
public class DrinkAdditiveController {
    @Autowired
    private DrinkAdditiveService drinkAdditiveService;
    @Autowired
    private DrinkAdditiveMapper drinkAdditiveMapper;

    @PostMapping
    public DrinkAdditiveGetDto saveNew(@RequestBody DrinkAdditivePostDto newDrinkAdditive) {
        DrinkAdditive drinkAdditive = drinkAdditiveService.save(newDrinkAdditive);
        return drinkAdditiveMapper.toGetDto(drinkAdditive);
    }

    @DeleteMapping
    public String deleteById(@RequestParam Long id) {
        drinkAdditiveService.deleteById(id);
        return "Drink was deleted";
    }

    @PutMapping
    public DrinkAdditiveGetDto updateDrink(@RequestBody DrinkAdditivePutDto newAdditiveInfo) {
        DrinkAdditive drinkAdditive = drinkAdditiveService.update(newAdditiveInfo);
        return drinkAdditiveMapper.toGetDto(drinkAdditive);
    }

    @GetMapping
    public DrinkAdditiveGetDto getById(@RequestParam Long id) {
        DrinkAdditive drinkAdditive = drinkAdditiveService.getById(id);
        return drinkAdditiveMapper.toGetDto(drinkAdditive);
    }
}
