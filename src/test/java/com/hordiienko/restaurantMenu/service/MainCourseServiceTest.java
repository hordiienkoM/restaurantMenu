package com.hordiienko.restaurantMenu.service;

import com.hordiienko.restaurantMenu.dto.MainCoursePostDto;
import com.hordiienko.restaurantMenu.dto.info_parent.MainCourseInfo;
import com.hordiienko.restaurantMenu.entity.Cuisine;
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
public class MainCourseServiceTest {
    @InjectMocks
    private MainCourseService mainCourseService;
    @Mock
    private CuisineService mockCuisineService;
    private Cuisine cuisine;
    private MainCourse trueMainCourse;
    private MainCoursePostDto mainCourseInfo;

    @Before
    public void addFields() {
        cuisine = new Cuisine();
        cuisine.setId(1L);

        trueMainCourse = new MainCourse();
        trueMainCourse.setCuisine(cuisine);
        trueMainCourse.setName("True name");
        trueMainCourse.setPrice(23.90);

        mainCourseInfo = new MainCoursePostDto();
        mainCourseInfo.setName(trueMainCourse.getName());
        mainCourseInfo.setPrice(trueMainCourse.getPrice());
        mainCourseInfo.setCuisineId(cuisine.getId());
    }

    @Test
    public void setInfoTest() {
        when(mockCuisineService.getById(cuisine.getId())).thenReturn(cuisine);

        MainCourse mainCourse = new MainCourse();
        mainCourseService.setInfo(mainCourse, mainCourseInfo);

        assertEquals(mainCourse, trueMainCourse);
    }
}
