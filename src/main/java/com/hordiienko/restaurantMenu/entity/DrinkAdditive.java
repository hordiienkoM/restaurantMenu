package com.hordiienko.restaurantMenu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "drink_additive")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class DrinkAdditive {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    @OneToMany(
            cascade = CascadeType.DETACH,
            orphanRemoval = true,
            mappedBy = "order"
    )
    private Set<DrinkAdditiveOrder> drinkAdditiveOrders;
}
