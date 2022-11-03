package com.hordiienko.restaurantMenu.controller;

import com.hordiienko.restaurantMenu.dto.DrinkAdditiveGetDto;
import com.hordiienko.restaurantMenu.entity.Dessert;
import com.hordiienko.restaurantMenu.mapper.DessertMapper;
import com.hordiienko.restaurantMenu.service.DessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/v1/desserts")
public class DessertController {
    @Autowired
    private DessertService dessertService;
    @Autowired
    private DessertMapper dessertMapper;

    @PostMapping
    public DrinkAdditiveGetDto.DessertGetDto saveNew(@RequestBody DrinkAdditiveGetDto.DessertPostDto newDessert) {
        Dessert dessert = dessertService.saveNew(newDessert);
        return dessertMapper.toGetDto(dessert);
    }

    @DeleteMapping
    public String deleteById(@RequestParam Long id) {
        dessertService.deleteById(id);
        return "Dessert was deleted";
    }

    @PutMapping
    public DrinkAdditiveGetDto.DessertGetDto updateDessert(@RequestBody DrinkAdditiveGetDto.DessertPutDto newInfo) {
        Dessert dessert = dessertService.update(newInfo);
        return dessertMapper.toGetDto(dessert);
    }

    @GetMapping
    public DrinkAdditiveGetDto.DessertGetDto getById(@RequestParam Long id) {
        Dessert dessert = dessertService.getById(id);
        return dessertMapper.toGetDto(dessert);
    }

    @GetMapping("/all_by_cuisine")
    public Set<DrinkAdditiveGetDto.DessertGetDto> getAllByCuisine(@RequestParam Long cuisineId) {
        Set<Dessert> desserts = dessertService.getAllByCousine(cuisineId);
        return dessertMapper.toGetDtos(desserts);
    }
}
