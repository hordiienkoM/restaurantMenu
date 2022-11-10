package com.hordiienko.restaurantMenu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RestaurantMenuApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestaurantMenuApplication.class, args);
    }
}
