package com.hordiienko.restaurantMenu.mapper;

import com.hordiienko.restaurantMenu.dto.MainCourseGetDto;
import com.hordiienko.restaurantMenu.entity.MainCourse;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper
public interface MainCourseMapper {
    MainCourseGetDto toGetDto(MainCourse mainCourse);

    Set<MainCourseGetDto> toGetDtos(Set<MainCourse> mainCourses);
}
