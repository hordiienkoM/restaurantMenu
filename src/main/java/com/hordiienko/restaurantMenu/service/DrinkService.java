package com.hordiienko.restaurantMenu.service;

import com.hordiienko.restaurantMenu.dto.DrinkPostDto;
import com.hordiienko.restaurantMenu.dto.DrinkPutDto;
import com.hordiienko.restaurantMenu.entity.Drink;
import com.hordiienko.restaurantMenu.repository.CuisineRepository;
import com.hordiienko.restaurantMenu.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DrinkService {
    @Autowired
    private DrinkRepository drinkRepository;
    @Autowired
    private CuisineRepository cuisineRepository;

    public Drink saveNew(DrinkPostDto drinkInfo) {
        Drink drink = new Drink();
        drink.setName(drinkInfo.getName());
        drink.setPrice(drinkInfo.getPrice());
        drink.setCuisine(
                cuisineRepository.findById(
                        drinkInfo.getCuisineId()
                ).orElseThrow());
        return drinkRepository.save(drink);
    }

    public void deleteById(Long id) {
        drinkRepository.deleteById(id);
    }

    public Drink update(DrinkPutDto drinkInfo) {
        Drink drink = drinkRepository.findById(drinkInfo.getId()).orElseThrow();
        drink.setName(drinkInfo.getName());
        drink.setPrice(drinkInfo.getPrice());
        drink.setCuisine(
                cuisineRepository.findById(
                        drinkInfo.getCuisineId()
                ).orElseThrow());
        return drinkRepository.save(drink);
    }

    public Drink getById(Long id) {
        return drinkRepository.findById(id).orElseThrow();
    }

    public Set<Drink> getAllByCousine(Long cuisineId) {
        return drinkRepository.findAllByCuisineId(cuisineId);
    }
}
