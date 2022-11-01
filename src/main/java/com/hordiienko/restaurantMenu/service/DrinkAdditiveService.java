package com.hordiienko.restaurantMenu.service;

import com.hordiienko.restaurantMenu.dto.*;
import com.hordiienko.restaurantMenu.entity.DrinkAdditive;
import com.hordiienko.restaurantMenu.repository.DrinkAdditiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkAdditiveService {
    @Autowired
    private DrinkAdditiveRepository drinkAdditiveRepository;

    public DrinkAdditive saveNew(DrinkAdditivePostDto drinkAdditiveInfo) {
        DrinkAdditive drinkAdditive = new DrinkAdditive();
        drinkAdditive.setName(drinkAdditiveInfo.getName());
        drinkAdditive.setPrice(drinkAdditiveInfo.getPrice());
        return drinkAdditiveRepository.save(drinkAdditive);
    }

    public void deleteById(Long id) {
        drinkAdditiveRepository.deleteById(id);
    }

    public DrinkAdditive update(DrinkAdditivePutDto drinkAdditiveInfo) {
        DrinkAdditive drinkAdditive = getById(drinkAdditiveInfo.getId());
        drinkAdditive.setName(drinkAdditiveInfo.getName());
        drinkAdditive.setPrice(drinkAdditiveInfo.getPrice());
        return drinkAdditiveRepository.save(drinkAdditive);
    }

    public DrinkAdditive getById(Long id) {
        return drinkAdditiveRepository.findById(id).orElseThrow();
    }
}
