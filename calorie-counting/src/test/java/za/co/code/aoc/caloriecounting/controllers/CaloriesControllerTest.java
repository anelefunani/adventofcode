package za.co.code.aoc.caloriecounting.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.caloriecounting.dao.CaloriesDao;
import za.co.code.aoc.caloriecounting.dao.impl.CaloriesDaoImpl;
import za.co.code.aoc.caloriecounting.services.CaloriesService;
import za.co.code.aoc.caloriecounting.services.impl.CaloriesServiceImpl;

class CaloriesControllerTest {

    private CaloriesDao caloriesDao;

    private CaloriesService caloriesService;

    private CaloriesController caloriesController;

    @BeforeEach
    void setUp() {
        caloriesDao = new CaloriesDaoImpl("src/test/resources/input.data");
        caloriesService = new CaloriesServiceImpl(caloriesDao);
        caloriesController = new CaloriesController(caloriesService);
    }

    @Test
    void shouldReturnMostCalories() {
        Assertions.assertEquals(24000, caloriesController.mostCalories());
    }

    @Test
    void shouldReturnTopMostCalories() {
        Assertions.assertEquals(45000, caloriesController.topThreeCalories());
    }
}