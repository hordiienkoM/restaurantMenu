package com.hordiienko.restaurantMenu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lunch_id")
    private Lunch lunch;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drink_id")
    private Drink drink;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "order"
    )
    private Set<DrinkAdditiveOrder> drinkAdditiveOrders;

    public Order(Lunch lunch) {
        this.lunch = lunch;
    }

    public Order(Drink drink) {
        this.drink = drink;
    }
    public Order(Drink drink, Set<DrinkAdditiveOrder> drinkAdditiveOrders) {
        this.drink = drink;
        this.drinkAdditiveOrders = drinkAdditiveOrders;
    }

    public Order(Lunch lunch, Drink drink, Set<DrinkAdditiveOrder> drinkAdditiveOrders) {
        this.lunch = lunch;
        this.drink = drink;
        this.drinkAdditiveOrders = drinkAdditiveOrders;
    }
}