package za.co.code.aoc.caloriecounting.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.caloriecounting.dao.CaloriesDao;

class CaloriesDaoImplTest {

    private static final String FILE_LOCATION = "src/test/resources/input.data";

    private CaloriesDao caloriesDao;


    @BeforeEach
    void setUp() {
        caloriesDao = new CaloriesDaoImpl(FILE_LOCATION);
    }

    @Test
    void shouldGetCaloriesPerElf() {
        Assertions.assertEquals(5, caloriesDao.getElves().getElves().size());
    }

}