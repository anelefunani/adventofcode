package za.co.code.aoc.rockpaperscissors;

import za.co.code.aoc.rockpaperscissors.adaptor.impl.RawToShapesDay2;
import za.co.code.aoc.rockpaperscissors.controller.GameController;
import za.co.code.aoc.rockpaperscissors.dao.impl.RockPaperScissorsDaoUsingFile;
import za.co.code.aoc.rockpaperscissors.service.impl.PlayGameServiceImpl;

public class Application {

    private static final String FILE_LOCATION = "rock-paper-scissors/src/main/resources/input.data";

    public static void main(String[] args) {
        GameController day1 = new GameController(new PlayGameServiceImpl(new RockPaperScissorsDaoUsingFile(FILE_LOCATION)));
        GameController day2 = new GameController(new PlayGameServiceImpl(new RockPaperScissorsDaoUsingFile(FILE_LOCATION, new RawToShapesDay2())));

        int gameScore = day1.play();
        System.out.println("Day 1 score: " + gameScore);
        gameScore = day2.play();
        System.out.println("Day 2 score: " + gameScore);
    }
}
