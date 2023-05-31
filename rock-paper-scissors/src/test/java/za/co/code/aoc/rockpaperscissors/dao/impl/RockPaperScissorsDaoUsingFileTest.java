package za.co.code.aoc.rockpaperscissors.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.rockpaperscissors.dao.RockPaperScissorsDao;
import za.co.code.aoc.rockpaperscissors.domain.Shapes;

class RockPaperScissorsDaoUsingFileTest {

    private RockPaperScissorsDao rockPaperScissorsDao;

    @BeforeEach
    void setUp() {
        rockPaperScissorsDao = new RockPaperScissorsDaoUsingFile("src/test/resources/input.data");
    }

    @Test
    void getRockPaperScissors() {
        Shapes shapes = rockPaperScissorsDao.getRockPaperScissors();
        Assertions.assertNotNull(shapes);
    }
}