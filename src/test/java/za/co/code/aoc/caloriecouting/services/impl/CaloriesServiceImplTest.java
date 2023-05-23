package za.co.code.aoc.caloriecouting.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.caloriecouting.dao.CaloriesDao;
import za.co.code.aoc.caloriecouting.dao.impl.CaloriesDaoImpl;
import za.co.code.aoc.caloriecouting.domain.value.ImmutableMostCalories;
import za.co.code.aoc.caloriecouting.domain.value.MostCalories;
import za.co.code.aoc.caloriecouting.services.CaloriesService;

class CaloriesServiceImplTest {

    private CaloriesDao caloriesDao;

    private CaloriesService caloriesService;

    @BeforeEach
    void setUp() {
        caloriesDao = new CaloriesDaoImpl("src/test/resources/input.data");
        caloriesService = new CaloriesServiceImpl(caloriesDao);
    }

    @Test
    void shouldReturnMostCalories() {
        MostCalories mostCalories = caloriesService.getMostCalories();
        Assertions.assertEquals(ImmutableMostCalories.of(24000), mostCalories);
    }
}