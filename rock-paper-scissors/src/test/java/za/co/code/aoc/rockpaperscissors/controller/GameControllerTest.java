package za.co.code.aoc.rockpaperscissors.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.rockpaperscissors.dao.RockPaperScissorsDao;
import za.co.code.aoc.rockpaperscissors.dao.impl.RockPaperScissorsDaoUsingFile;
import za.co.code.aoc.rockpaperscissors.service.PlayGameService;
import za.co.code.aoc.rockpaperscissors.service.impl.PlayGameServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    private RockPaperScissorsDao rockPaperScissorsDao;

    private PlayGameService gameService;

    private GameController gameController;

    @BeforeEach
    void setUp() {
        rockPaperScissorsDao = new RockPaperScissorsDaoUsingFile("src/test/resources/input.data");
        gameService = new PlayGameServiceImpl(rockPaperScissorsDao);
        gameController = new GameController(gameService);
    }

    @Test
    void play() {
        int score = gameController.play();
        Assertions.assertEquals(15, score);
    }
}