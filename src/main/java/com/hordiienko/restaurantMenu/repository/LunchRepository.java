package com.hordiienko.restaurantMenu.repository;

import com.hordiienko.restaurantMenu.entity.Lunch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface LunchRepository extends JpaRepository<Lunch, Long> {
    Set<Lunch> findAllByCuisineId(Long cuisineId);
}
