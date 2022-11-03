package com.hordiienko.restaurantMenu.service;

import com.hordiienko.restaurantMenu.dto.LunchPostDto;
import com.hordiienko.restaurantMenu.dto.LunchPutDto;
import com.hordiienko.restaurantMenu.dto.info_parent.LunchInfo;
import com.hordiienko.restaurantMenu.entity.Lunch;
import com.hordiienko.restaurantMenu.repository.LunchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LunchService {
    @Autowired
    private LunchRepository lunchRepository;
    @Autowired
    private CuisineService cuisineService;
    @Autowired
    private DessertService dessertService;
    @Autowired
    private MainCourseService mainCourseService;

    public Lunch save(LunchPostDto lunchInfo) {
        Lunch lunch = new Lunch();
        setInfo(lunch, lunchInfo);
        return lunchRepository.save(lunch);
    }

    public void deleteById(Long id) {
        lunchRepository.deleteById(id);
    }

    public Lunch update(LunchPutDto lunchInfo) {
        Lunch lunch = lunchRepository.findById(
                lunchInfo.getId()
        ).orElseThrow();
        setInfo(lunch, lunchInfo);
        return lunchRepository.save(lunch);
    }

    protected void setInfo(Lunch lunch, LunchInfo lunchInfo) {
        lunch.setMainCourse(
                mainCourseService.getById(lunchInfo.getMainCourseId()));
        lunch.setDessert(
                dessertService.getById(lunchInfo.getDessertId())
        );
        lunch.setCuisine(
                cuisineService.getById(lunchInfo.getCuisineId()));
        lunch.setName(lunchInfo.getName());
    }

    public Lunch getById(Long id) {
        return lunchRepository.findById(id).orElseThrow();
    }

    public Set<Lunch> getAllByCousineId(Long cuisineId) {
        return lunchRepository.findAllByCuisineId(cuisineId);
    }
}
