package za.co.code.aoc.rockpaperscissors.service.impl;

import za.co.code.aoc.rockpaperscissors.dao.RockPaperScissorsDao;
import za.co.code.aoc.rockpaperscissors.domain.GameScore;
import za.co.code.aoc.rockpaperscissors.domain.ImmutableGameScore;
import za.co.code.aoc.rockpaperscissors.domain.Shapes;
import za.co.code.aoc.rockpaperscissors.domain.enums.RoundScore;
import za.co.code.aoc.rockpaperscissors.domain.enums.Shape;
import za.co.code.aoc.rockpaperscissors.service.PlayGameService;

import java.util.Map;

public class PlayGameServiceImpl implements PlayGameService {

    private final RockPaperScissorsDao rockPaperScissorsDao;

    public PlayGameServiceImpl(RockPaperScissorsDao rockPaperScissorsDao) {
        this.rockPaperScissorsDao = rockPaperScissorsDao;
    }

    @Override
    public GameScore play() {
        Shapes shapes = rockPaperScissorsDao.getRockPaperScissors();
        int score = 0;
        for(Map<Shape, Shape> shapeMap : shapes.getValue()) {
            for (Map.Entry<Shape, Shape> shapeEntry : shapeMap.entrySet()) {
                if (shapeEntry.getKey() == Shape.R && shapeEntry.getValue() == Shape.S) {
                    score += RoundScore.L.getWeight() + Shape.S.getWeight();
                } else if (shapeEntry.getKey() == Shape.S && shapeEntry.getValue() == Shape.P) {
                    score += RoundScore.L.getWeight() + Shape.P.getWeight();
                } else if (shapeEntry.getKey() == Shape.P && shapeEntry.getValue() == Shape.R) {
                    score += RoundScore.L.getWeight() + Shape.R.getWeight();
                } else if (shapeEntry.getKey() == shapeEntry.getValue()) {
                    score += RoundScore.D.getWeight() + shapeEntry.getValue().getWeight();
                } else if (shapeEntry.getKey() == Shape.P && shapeEntry.getValue() == Shape.S) {
                    score += RoundScore.W.getWeight() + Shape.S.getWeight();
                } else if (shapeEntry.getKey() == Shape.R && shapeEntry.getValue() == Shape.P) {
                    score += RoundScore.W.getWeight() + Shape.P.getWeight();
                } else if (shapeEntry.getKey() == Shape.S && shapeEntry.getValue() == Shape.R) {
                    score += RoundScore.W.getWeight() + Shape.R.getWeight();
                } else {
                    throw new IllegalStateException("Something went wrong, we could not match any conditions.");
                }
            }
        }
        return ImmutableGameScore.of(score);
    }
}
