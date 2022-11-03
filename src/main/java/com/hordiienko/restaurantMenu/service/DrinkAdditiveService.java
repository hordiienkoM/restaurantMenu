package com.hordiienko.restaurantMenu.service;

import com.hordiienko.restaurantMenu.dto.*;
import com.hordiienko.restaurantMenu.dto.info_parent.DrinkAdditiveInfo;
import com.hordiienko.restaurantMenu.entity.DrinkAdditive;
import com.hordiienko.restaurantMenu.repository.DrinkAdditiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class DrinkAdditiveService {
    @Autowired
    private DrinkAdditiveRepository drinkAdditiveRepository;

    public DrinkAdditive save(DrinkAdditivePostDto drinkAdditiveInfo) {
        DrinkAdditive drinkAdditive = new DrinkAdditive();
        saveInfo(drinkAdditive, drinkAdditiveInfo);
        return drinkAdditiveRepository.save(drinkAdditive);
    }

    public void deleteById(Long id) {
        drinkAdditiveRepository.deleteById(id);
    }

    public DrinkAdditive update(DrinkAdditivePutDto drinkAdditiveInfo) {
        DrinkAdditive drinkAdditive = getById(drinkAdditiveInfo.getId());
        saveInfo(drinkAdditive, drinkAdditiveInfo);
        return drinkAdditiveRepository.save(drinkAdditive);
    }

    public void saveInfo(DrinkAdditive drinkAdditive, DrinkAdditiveInfo drinkAdditiveInfo) {
        drinkAdditive.setName(drinkAdditiveInfo.getName());
        drinkAdditive.setPrice(drinkAdditiveInfo.getPrice());
    }

    public DrinkAdditive getById(Long id) {
        return drinkAdditiveRepository.findById(id).orElseThrow();
    }

    public Map<Long, DrinkAdditive> getAllAdditives() {
        Set<DrinkAdditive> additiveSet = drinkAdditiveRepository.findAllBy();
        Map<Long, DrinkAdditive> additiveMap = new HashMap<>();
        additiveSet.forEach(e -> {
            additiveMap.put(e.getId(), e);
        });
        return additiveMap;
    }
}
