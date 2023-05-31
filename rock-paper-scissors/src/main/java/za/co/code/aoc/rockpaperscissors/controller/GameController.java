package za.co.code.aoc.rockpaperscissors.controller;

import za.co.code.aoc.rockpaperscissors.service.PlayGameService;

public class GameController {

    private final PlayGameService gameService;

    public GameController(PlayGameService gameService) {
        this.gameService = gameService;
    }

    public int play() {
        return gameService.play().getValue();
    }
}
