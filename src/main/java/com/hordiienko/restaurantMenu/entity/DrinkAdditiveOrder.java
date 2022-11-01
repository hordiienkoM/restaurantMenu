package com.hordiienko.restaurantMenu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "drink_additive_order")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class DrinkAdditiveOrder {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drink_additive_id")
    private DrinkAdditive drinkAdditive;
    private int amount;
}
