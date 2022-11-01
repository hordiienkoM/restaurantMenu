package com.hordiienko.restaurantMenu.controller;

import com.hordiienko.restaurantMenu.dto.*;
import com.hordiienko.restaurantMenu.entity.MainCourse;
import com.hordiienko.restaurantMenu.mapper.MainCourseMapper;
import com.hordiienko.restaurantMenu.service.MainCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/v1/main_courses")
public class MainCourseController {
    @Autowired
    private MainCourseService mainCourseService;
    @Autowired
    private MainCourseMapper mainCourseMapper;

    @PostMapping
    public MainCourseGetDto saveNew(@RequestBody MainCoursePostDto newMainCourse) {
        MainCourse mainCourse = mainCourseService.saveNew(newMainCourse);
        return mainCourseMapper.toGetDto(mainCourse);
    }

    @DeleteMapping
    public String deleteById(@RequestParam Long id) {
        mainCourseService.deleteById(id);
        return "Main Course was deleted";
    }

    @PutMapping
    public MainCourseGetDto updateMainCourse(@RequestBody MainCoursePutDto newInfo) {
        MainCourse mainCourse = mainCourseService.update(newInfo);
        return mainCourseMapper.toGetDto(mainCourse);
    }

    @GetMapping
    public MainCourseGetDto getById(@RequestParam Long id) {
        MainCourse mainCourse = mainCourseService.getById(id);
        return mainCourseMapper.toGetDto(mainCourse);
    }

    @GetMapping("/all_by_cuisine")
    public Set<MainCourseGetDto> getAllByCuisine(@RequestParam Long cuisineId) {
        Set<MainCourse> mainCourses = mainCourseService.getAllByCousine(cuisineId);
        return mainCourseMapper.toGetDtos(mainCourses);
    }
}
