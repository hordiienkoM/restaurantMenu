package com.hordiienko.restaurantMenu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cuisine")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Cuisine {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(
            cascade = CascadeType.DETACH,
            orphanRemoval = true,
            mappedBy = "cuisine"
    )
    private Set<MainCourse> mainCourses;
    @OneToMany(
            cascade = CascadeType.DETACH,
            orphanRemoval = true,
            mappedBy = "cuisine"
    )
    private Set<Dessert> desserts;
    @OneToMany(
            cascade = CascadeType.DETACH,
            orphanRemoval = true,
            mappedBy = "cuisine"
    )
    private Set<Lunch> lunches;
    @OneToMany(
            cascade = CascadeType.DETACH,
            orphanRemoval = true,
            mappedBy = "cuisine"
    )
    private Set<Lunch> drinks;
}
