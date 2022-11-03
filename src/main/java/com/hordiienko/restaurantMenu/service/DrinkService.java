package com.hordiienko.restaurantMenu.service;

import com.hordiienko.restaurantMenu.dto.DrinkPostDto;
import com.hordiienko.restaurantMenu.dto.DrinkPutDto;
import com.hordiienko.restaurantMenu.dto.info_parent.DrinkInfo;
import com.hordiienko.restaurantMenu.entity.Cuisine;
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
        saveInfo(drink, drinkInfo);
        return drinkRepository.save(drink);
    }

    public void deleteById(Long id) {
        drinkRepository.deleteById(id);
    }

    public Drink update(DrinkPutDto drinkInfo) {
        Drink drink = drinkRepository.findById(drinkInfo.getId()).orElseThrow();
        saveInfo(drink, drinkInfo);
        return drinkRepository.save(drink);
    }

    protected void saveInfo(Drink drink, DrinkInfo drinkInfo) {
        Cuisine cuisine = cuisineRepository.findById(
                drinkInfo.getCuisineId()
        ).orElseThrow();
        drink.setName(drinkInfo.getName());
        drink.setPrice(drinkInfo.getPrice());
        drink.setCuisine(cuisine);
    }

    public Drink getById(Long id) {
        return drinkRepository.findById(id).orElseThrow();
    }

    public Set<Drink> getAllByCousine(Long cuisineId) {
        return drinkRepository.findAllByCuisineId(cuisineId);
    }
}
