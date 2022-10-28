package com.hordiienko.restaurantMenu.repository;

import com.hordiienko.restaurantMenu.entity.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuisineRepository extends JpaRepository<Cuisine, Long> {
    Cuisine findFirstByName(String name);
}
