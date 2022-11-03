package com.hordiienko.restaurantMenu.service;

import com.hordiienko.restaurantMenu.dto.LunchPostDto;
import com.hordiienko.restaurantMenu.entity.Cuisine;
import com.hordiienko.restaurantMenu.entity.Dessert;
import com.hordiienko.restaurantMenu.entity.Lunch;
import com.hordiienko.restaurantMenu.entity.MainCourse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LunchServiceTest {
    @InjectMocks
    private LunchService lunchService;
    @Mock
    private MainCourseService mockMainCourseService;
    @Mock
    private DessertService mockDessertService;
    @Mock
    private CuisineService mockCuisineService;
    private LunchPostDto lunchInfo;
    private MainCourse mainCourse;
    private Dessert dessert;
    private Cuisine cuisine;
    private Lunch trueLunch;

    @Before
    public void addFields() {
        lunchInfo = new LunchPostDto();
        lunchInfo.setName("True lunch");
        lunchInfo.setCuisineId(6L);
        lunchInfo.setDessertId(2L);
        lunchInfo.setMainCourseId(1L);

        mainCourse = new MainCourse();
        mainCourse.setId(1L);

        dessert = new Dessert();
        dessert.setId(2L);

        cuisine = new Cuisine();
        cuisine.setId(6L);

        trueLunch = new Lunch();
        trueLunch.setName(lunchInfo.getName());
        trueLunch.setCuisine(cuisine);
        trueLunch.setDessert(dessert);
        trueLunch.setMainCourse(mainCourse);
    }

    @Test
    public void setInfoTest() {
        when(mockCuisineService.getById(cuisine.getId())).thenReturn(cuisine);
        when(mockDessertService.getById(dessert.getId())).thenReturn(dessert);
        when(mockMainCourseService.getById(mainCourse.getId())).thenReturn(mainCourse);

        Lunch lunch = new Lunch();
        lunchService.setInfo(lunch, lunchInfo);
        assertEquals(lunch, trueLunch);
    }
}
