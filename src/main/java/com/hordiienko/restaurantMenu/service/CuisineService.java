package com.hordiienko.restaurantMenu.service;

import com.hordiienko.restaurantMenu.dto.CuisinePutDto;
import com.hordiienko.restaurantMenu.entity.Cuisine;
import com.hordiienko.restaurantMenu.entity.Dessert;
import com.hordiienko.restaurantMenu.repository.CuisineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CuisineService {
    @Autowired
    private CuisineRepository cuisineRepository;

    public Cuisine saveNew(String cuisineName) {
        Cuisine cuisine = new Cuisine();
        cuisine.setName(cuisineName);
        return cuisineRepository.save(cuisine);
    }

    public void deleteById(Long id) {
        cuisineRepository.deleteById(id);
    }

    public Cuisine update(CuisinePutDto newCuisine) {
        Cuisine cuisine = cuisineRepository.findById(newCuisine.getId()).orElseThrow();
        cuisine.setName(newCuisine.getName());
        return cuisineRepository.save(cuisine);
    }

    public Cuisine getByName(String name) {
        return cuisineRepository.findFirstByName(name);
    }

    public Cuisine getById(Long id) {
        return cuisineRepository.findById(id).orElseThrow();
    }
}
