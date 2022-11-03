package com.hordiienko.restaurantMenu.service;

import com.hordiienko.restaurantMenu.dto.MainCoursePostDto;
import com.hordiienko.restaurantMenu.dto.MainCoursePutDto;
import com.hordiienko.restaurantMenu.dto.info_parent.MainCourseInfo;
import com.hordiienko.restaurantMenu.entity.Cuisine;
import com.hordiienko.restaurantMenu.entity.MainCourse;
import com.hordiienko.restaurantMenu.repository.MainCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MainCourseService {
    @Autowired
    private MainCourseRepository mainCourseRepository;
    @Autowired
    private CuisineService cuisineService;

    public MainCourse save(MainCoursePostDto mainCourseInfo) {
        MainCourse mainCourse = new MainCourse();
        setInfo(mainCourse, mainCourseInfo);
        return mainCourseRepository.save(mainCourse);
    }

    public void deleteById(Long id) {
        mainCourseRepository.deleteById(id);
    }

    public MainCourse update(MainCoursePutDto mainCourseInfo) {
        MainCourse mainCourse = mainCourseRepository.findById(mainCourseInfo.getId()).orElseThrow();
        setInfo(mainCourse, mainCourseInfo);
        return mainCourseRepository.save(mainCourse);
    }

    protected void setInfo(MainCourse mainCourse, MainCourseInfo mainCourseInfo) {
        Cuisine cuisine = cuisineService.getById(
                mainCourseInfo.getCuisineId());
        mainCourse.setName(mainCourseInfo.getName());
        mainCourse.setPrice(mainCourseInfo.getPrice());
        mainCourse.setCuisine(cuisine);
    }

    public MainCourse getById(Long id) {
        return mainCourseRepository.findById(id).orElseThrow();
    }

    public Set<MainCourse> getAllByCousine(Long cuisineId) {
        return mainCourseRepository.findAllByCuisineId(cuisineId);
    }
}
