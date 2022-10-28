package com.hordiienko.restaurantMenu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "dessert")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Dessert {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;
    @OneToMany(
            cascade = CascadeType.DETACH,
            orphanRemoval = true,
            mappedBy = "dessert"
    )
    private Set<Lunch> lunchs;
}
