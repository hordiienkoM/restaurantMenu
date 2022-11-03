package com.hordiienko.restaurantMenu.repository;

import com.hordiienko.restaurantMenu.entity.DrinkAdditive;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface DrinkAdditiveRepository extends JpaRepository<DrinkAdditive, Long> {
    Set<DrinkAdditive> findAllBy();
}
