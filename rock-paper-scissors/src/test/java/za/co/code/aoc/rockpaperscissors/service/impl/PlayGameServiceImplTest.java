package za.co.code.aoc.rockpaperscissors.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.rockpaperscissors.adaptor.impl.RawToShapesDay2;
import za.co.code.aoc.rockpaperscissors.dao.RockPaperScissorsDao;
import za.co.code.aoc.rockpaperscissors.dao.impl.RockPaperScissorsDaoUsingFile;
import za.co.code.aoc.rockpaperscissors.domain.GameScore;
import za.co.code.aoc.rockpaperscissors.domain.ImmutableGameScore;
import za.co.code.aoc.rockpaperscissors.service.PlayGameService;

import static org.junit.jupiter.api.Assertions.*;

class PlayGameServiceImplTest {

    private RockPaperScissorsDao rockPaperScissorsDao = new RockPaperScissorsDaoUsingFile("src/test/resources/input.data", new RawToShapesDay2());
    private PlayGameService gameService;

    @BeforeEach
    void setUp() {
        rockPaperScissorsDao = new RockPaperScissorsDaoUsingFile("src/test/resources/input.data");
        gameService = new PlayGameServiceImpl(rockPaperScissorsDao);
    }

    @Test
    void playDay1() {
        GameScore gameScore = gameService.play();
        Assertions.assertEquals(ImmutableGameScore.of(15), gameScore);
    }

    @Test
    void playDay2() {
        rockPaperScissorsDao = new RockPaperScissorsDaoUsingFile("src/test/resources/input.data", new RawToShapesDay2());
        gameService = new PlayGameServiceImpl(rockPaperScissorsDao);
        GameScore gameScore = gameService.play();
        Assertions.assertEquals(ImmutableGameScore.of(12), gameScore);
    }
}