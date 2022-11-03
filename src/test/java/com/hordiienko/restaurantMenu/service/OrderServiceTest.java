package com.hordiienko.restaurantMenu.service;

import com.hordiienko.restaurantMenu.dto.DrinkAdditiveOrderPostDto;
import com.hordiienko.restaurantMenu.dto.order_dto.OrderPostDto;
import com.hordiienko.restaurantMenu.dto.order_dto.OrderPutDto;
import com.hordiienko.restaurantMenu.entity.*;
import com.hordiienko.restaurantMenu.repository.DrinkAdditiveRepository;
import com.hordiienko.restaurantMenu.repository.DrinkRepository;
import com.hordiienko.restaurantMenu.repository.LunchRepository;
import com.hordiienko.restaurantMenu.repository.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
    @InjectMocks
    private OrderService mockOrderService;
    @Mock
    private LunchRepository mockLunchRepository;
    @Mock
    private DrinkRepository mockDrinkRepository;
    @Mock
    private DrinkAdditiveRepository mockAdditiveRepository;

    private Order trueComplexOrder;
    private Order trueLunchDrinkOrder;
    private Order trueComplexDrinkOrder;
    private Order trueJustDrinkOrder;
    private Order trueJustLunchOrder;
    private OrderPutDto trueComplexOrderPut;
    private OrderPutDto trueLunchDrinkOrderPut;
    private OrderPutDto trueComplexDrinkOrderPut;
    private OrderPutDto trueJustDrinkOrderPut;
    private OrderPutDto trueJustLunchOrderPut;
    private DrinkAdditive drinkAdditive;
    private Set<DrinkAdditiveOrder> trueDrinkAdditiveOrders;

    @Before
    public void addTrueOrders() {
        trueComplexOrder = new Order();
        trueComplexOrder.setId(1L);
        trueComplexOrder.setDrinkAdditiveOrders(Collections.emptySet());
        trueComplexOrder.setLunch(new Lunch());
        trueComplexOrder.setDrink(new Drink());

        trueLunchDrinkOrder = new Order();
        trueLunchDrinkOrder.setDrink(new Drink());
        trueLunchDrinkOrder.setLunch(new Lunch());
        trueLunchDrinkOrder.setId(2L);

        trueComplexDrinkOrder = new Order();
        trueComplexDrinkOrder.setId(3L);
        trueComplexDrinkOrder.setDrink(new Drink());
        trueComplexDrinkOrder.setDrinkAdditiveOrders(Collections.emptySet());

        trueJustDrinkOrder = new Order();
        trueJustDrinkOrder.setId(4L);
        trueJustDrinkOrder.setDrink(new Drink());

        trueJustLunchOrder = new Order();
        trueJustLunchOrder.setId(5L);
        trueJustLunchOrder.setLunch(new Lunch());
    }

    @Before
    public void addTrueOrderDtos() {
        trueComplexOrderPut = new OrderPutDto();
        trueComplexOrderPut.setId(1L);
        trueComplexOrderPut.setDrinkAdditiveOrders(Collections.emptySet());
        trueComplexOrderPut.setLunchId(1L);
        trueComplexOrderPut.setDrinkId(1L);

        trueLunchDrinkOrderPut = new OrderPutDto();
        trueLunchDrinkOrderPut.setDrinkId(1L);
        trueLunchDrinkOrderPut.setLunchId(1L);
        trueLunchDrinkOrderPut.setId(2L);

        trueComplexDrinkOrderPut = new OrderPutDto();
        trueComplexDrinkOrderPut.setId(3L);
        trueComplexDrinkOrderPut.setDrinkId(1L);
        trueComplexDrinkOrderPut.setDrinkAdditiveOrders(Collections.emptySet());

        trueJustDrinkOrderPut = new OrderPutDto();
        trueJustDrinkOrderPut.setId(4L);
        trueJustDrinkOrderPut.setDrinkId(1L);

        trueJustLunchOrderPut = new OrderPutDto();
        trueJustLunchOrderPut.setId(5L);
        trueJustLunchOrderPut.setLunchId(1L);
    }

    @Before
    public void createTrueDrinkAdditiveOrders() {
        drinkAdditive = new DrinkAdditive();
        drinkAdditive.setName("Lemon");
        drinkAdditive.setId(1L);
        drinkAdditive.setPrice(43.5);

        DrinkAdditiveOrder trueFirst = new DrinkAdditiveOrder();
        trueFirst.setDrinkAdditive(drinkAdditive);
        trueFirst.setAmount(5);
        DrinkAdditiveOrder trueSecond = new DrinkAdditiveOrder();
        trueSecond.setDrinkAdditive(drinkAdditive);
        trueSecond.setAmount(3);
        DrinkAdditiveOrder trueThird = new DrinkAdditiveOrder();
        trueThird.setDrinkAdditive(drinkAdditive);
        trueThird.setAmount(1);

        trueDrinkAdditiveOrders = new HashSet<>(List.of(
                trueFirst, trueSecond, trueThird
        ));
    }

    @Test(expected = RuntimeException.class)
    public void setInfoTestException() {
        OrderPostDto wrongOrderPostDto = new OrderPostDto();
        wrongOrderPostDto.setDrinkAdditiveOrders(Collections.emptySet());
        mockOrderService.saveNew(wrongOrderPostDto);
    }

    @Test
    public void setInfoTest() {
        when(mockLunchRepository.findById(1L)).thenReturn(Optional.of(new Lunch()));
        when(mockDrinkRepository.findById(1L)).thenReturn(Optional.of(new Drink()));

        Order orderComplex = mockOrderService.setInfo(trueComplexOrderPut);
        Order orderLunchDrink = mockOrderService.setInfo(trueLunchDrinkOrderPut);
        Order orderComplexDrink = mockOrderService.setInfo(trueComplexDrinkOrderPut);
        Order orderDrink = mockOrderService.setInfo(trueJustDrinkOrderPut);
        Order orderLunch = mockOrderService.setInfo(trueJustLunchOrderPut);

        assertEquals(orderComplex, trueComplexOrder);
        assertEquals(orderLunchDrink, trueLunchDrinkOrder);
        assertEquals(orderComplexDrink, trueComplexDrinkOrder);
        assertEquals(orderDrink, trueJustDrinkOrder);
        assertEquals(orderLunch, trueJustLunchOrder);
    }

    @Test
    public void saveDrinkAdditivesTest() {
        when(mockAdditiveRepository.findById(anyLong()))
                .thenReturn(Optional.of(drinkAdditive));
        Order order = new Order();
        OrderPostDto orderInfo = new OrderPostDto();
        orderInfo.setDrinkAdditiveOrders(
                new HashSet<>(List.of(
                        new DrinkAdditiveOrderPostDto(1L, 5),
                        new DrinkAdditiveOrderPostDto(1L, 3),
                        new DrinkAdditiveOrderPostDto(1L, 1)
                )));

        mockOrderService.saveDrinkAdditives(order, orderInfo);
        Set<DrinkAdditiveOrder> drinkAdditiveOrders = order.getDrinkAdditiveOrders();
        assertEquals(drinkAdditiveOrders, trueDrinkAdditiveOrders);
    }

}
