package com.hordiienko.restaurantMenu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "lunch")
@Getter
@Setter
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Lunch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "main_course_id")
    private MainCourse mainCourse;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dessert_id")
    private Dessert dessert;
    @OneToMany(
            cascade = CascadeType.DETACH,
            mappedBy = "drink"
    )
    private Set<Order> orders;
}
