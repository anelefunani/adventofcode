package za.co.code.aoc.caloriecounting.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.caloriecounting.dao.CaloriesDao;
import za.co.code.aoc.caloriecounting.dao.impl.CaloriesDaoImpl;
import za.co.code.aoc.caloriecounting.domain.value.*;
import za.co.code.aoc.caloriecounting.services.CaloriesService;

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

    @Test
    void shouldReturnTopThreeCalories() {
        TopMostCalories topMostCalories = caloriesService.getTopMostCalories();
        Assertions.assertEquals(ImmutableTopMostCalories.of(45000), topMostCalories);
    }
}