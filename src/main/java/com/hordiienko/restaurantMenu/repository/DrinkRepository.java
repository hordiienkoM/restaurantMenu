package com.hordiienko.restaurantMenu.repository;

import com.hordiienko.restaurantMenu.entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
    Set<Drink> findAllByCuisineId(Long cuisineId);
}
