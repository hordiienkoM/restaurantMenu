package com.hordiienko.restaurantMenu.controller;

import com.hordiienko.restaurantMenu.dto.DessertGetDto;
import com.hordiienko.restaurantMenu.dto.DessertPostDto;
import com.hordiienko.restaurantMenu.dto.DessertPutDto;
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
    public DessertGetDto saveNew(@RequestBody DessertPostDto newDessert) {
        Dessert dessert = dessertService.saveNew(newDessert);
        return dessertMapper.toGetDto(dessert);
    }

    @DeleteMapping
    public String deleteById(@RequestParam Long id) {
        dessertService.deleteById(id);
        return "Dessert was deleted";
    }

    @PutMapping
    public DessertGetDto updateDessert(@RequestBody DessertPutDto newInfo) {
        Dessert dessert = dessertService.update(newInfo);
        return dessertMapper.toGetDto(dessert);
    }

    @GetMapping
    public DessertGetDto getById(@RequestParam Long id) {
        Dessert dessert = dessertService.getById(id);
        return dessertMapper.toGetDto(dessert);
    }

    @GetMapping("/all_by_cuisine")
    public Set<DessertGetDto> getAllByCuisine(@RequestParam Long cuisineId) {
        Set<Dessert> desserts = dessertService.getAllByCousine(cuisineId);
        return dessertMapper.toGetDtos(desserts);
    }
}
