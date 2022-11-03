package com.hordiienko.restaurantMenu.controller;

import com.hordiienko.restaurantMenu.dto.CuisineGetDto;
import com.hordiienko.restaurantMenu.dto.CuisinePutDto;
import com.hordiienko.restaurantMenu.entity.Cuisine;
import com.hordiienko.restaurantMenu.mapper.CuisineMapper;
import com.hordiienko.restaurantMenu.service.CuisineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cuisines")
public class CuisineController {
    @Autowired
    private CuisineService cuisineService;
    @Autowired
    private CuisineMapper cuisineMapper;

    @PostMapping
    public CuisineGetDto saveNew(@RequestParam String cuisineName) {
        Cuisine cuisine = cuisineService.save(cuisineName);
        return cuisineMapper.toGetDto(cuisine);
    }

    @DeleteMapping
    public String deleteById(@RequestParam Long cuisineId) {
        cuisineService.deleteById(cuisineId);
        return "Cuisine has been deleted";
    }

    @PutMapping
    public CuisineGetDto update(@RequestBody CuisinePutDto newCuisineInfo) {
        Cuisine cuisine = cuisineService.update(newCuisineInfo);
        return cuisineMapper.toGetDto(cuisine);
    }

    @GetMapping
    public CuisineGetDto getByName(@RequestParam String name) {
        Cuisine cuisine = cuisineService.getByName(name);
        return cuisineMapper.toGetDto(cuisine);
    }

}
