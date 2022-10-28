package com.hordiienko.restaurantMenu.repository;

import com.hordiienko.restaurantMenu.entity.Dessert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface DessertRepository extends JpaRepository<Dessert, Long> {
    Set<Dessert> findAllByCuisineId(Long cuisineId);
}
