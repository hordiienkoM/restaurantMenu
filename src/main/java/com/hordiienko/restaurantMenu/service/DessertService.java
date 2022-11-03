package com.hordiienko.restaurantMenu.service;

import com.hordiienko.restaurantMenu.dto.DessertPostDto;
import com.hordiienko.restaurantMenu.dto.DessertPutDto;
import com.hordiienko.restaurantMenu.dto.info_parent.DessertInfo;
import com.hordiienko.restaurantMenu.entity.Cuisine;
import com.hordiienko.restaurantMenu.entity.Dessert;
import com.hordiienko.restaurantMenu.repository.CuisineRepository;
import com.hordiienko.restaurantMenu.repository.DessertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DessertService {
    @Autowired
    private DessertRepository dessertRepository;
    @Autowired
    private CuisineRepository cuisineRepository;

    public Dessert save(DessertPostDto dessertInfo) {
        Dessert dessert = new Dessert();
        setDessertInfo(dessert, dessertInfo);
        return dessertRepository.save(dessert);
    }

    public void deleteById(Long id) {
        dessertRepository.deleteById(id);
    }

    public Dessert update(DessertPutDto dessertInfo) {
        Dessert dessert = dessertRepository.findById(dessertInfo.getId()).orElseThrow();
        setDessertInfo(dessert, dessertInfo);
        return dessertRepository.save(dessert);
    }

    protected void setDessertInfo(Dessert dessert, DessertInfo dessertInfo) {
        Cuisine cuisine = cuisineRepository.findById(
                dessertInfo.getCuisineId()
        ).orElseThrow();
        dessert.setName(dessertInfo.getName());
        dessert.setPrice(dessertInfo.getPrice());
        dessert.setCuisine(cuisine);
    }

    public Dessert getById(Long id) {
        return dessertRepository.findById(id).orElseThrow();
    }

    public Set<Dessert> getAllByCousine(Long cuisineId) {
        return dessertRepository.findAllByCuisineId(cuisineId);
    }
}
