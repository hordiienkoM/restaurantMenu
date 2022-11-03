package com.hordiienko.restaurantMenu.controller;

import com.hordiienko.restaurantMenu.dto.*;
import com.hordiienko.restaurantMenu.dto.LunchGetDto;
import com.hordiienko.restaurantMenu.entity.Lunch;
import com.hordiienko.restaurantMenu.mapper.LunchMapper;
import com.hordiienko.restaurantMenu.service.LunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/v1/lunches")
public class LunchController {
    @Autowired
    private LunchService lunchService;
    @Autowired
    private LunchMapper lunchMapper;

    @PostMapping
    public LunchGetDto saveNew(@RequestBody LunchPostDto newLunch) {
        Lunch lunch = lunchService.save(newLunch);
        return lunchMapper.toGetDto(lunch);
    }

    @DeleteMapping
    public String deleteById(@RequestParam Long id) {
        lunchService.deleteById(id);
        return "Lunch was deleted";
    }

    @PutMapping
    public LunchGetDto updateLunch(@RequestBody LunchPutDto newInfo) {
        Lunch lunch = lunchService.update(newInfo);
        return lunchMapper.toGetDto(lunch);
    }

    @GetMapping
    public LunchGetDto getById(@RequestParam Long id) {
        Lunch lunch = lunchService.getById(id);
        return lunchMapper.toGetDto(lunch);
    }

    @GetMapping("/all_by_cuisine")
    public Set<LunchGetDto> getAllByCuisine(@RequestParam Long cuisineId) {
        Set<Lunch> lunches = lunchService.getAllByCousineId(cuisineId);
        return lunchMapper.toGetDtos(lunches);
    }
}
