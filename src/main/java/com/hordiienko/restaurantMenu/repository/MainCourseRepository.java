package com.hordiienko.restaurantMenu.repository;

import com.hordiienko.restaurantMenu.entity.Cuisine;
import com.hordiienko.restaurantMenu.entity.MainCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface MainCourseRepository extends JpaRepository<MainCourse, Long> {
    Set<MainCourse> findAllByCuisineId(Long cuisineId);
}
