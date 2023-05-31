package za.co.code.aoc.rockpaperscissors.adaptor.impl;

import za.co.code.aoc.rockpaperscissors.adaptor.Adaptor;
import za.co.code.aoc.rockpaperscissors.domain.enums.Shape;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RawToShapesDay2 implements Adaptor<String, Map<Shape, Shape>> {
    @Override
    public Map<Shape, Shape> adapt(String rawShapes) {
        String[] splitShapes = rawShapes.split(" ");
        Map<Shape, Shape> shapes = new HashMap<>();
        Shape them = null;
        Shape me = null;
        for (String s : splitShapes) {
            if (s.equalsIgnoreCase("A")) {
                them = Shape.R;
            } else if (s.equalsIgnoreCase("B")) {
                them = Shape.P;
            } else if (s.equalsIgnoreCase("C")) {
                them = Shape.S;
            } else if (s.equalsIgnoreCase("X")) {
                if (them == Shape.P) {
                    me = Shape.R;
                } else if (them == Shape.R) {
                    me = Shape.S;
                } else if (them == Shape.S) {
                    me = Shape.P;
                } else {
                    throw new IllegalStateException("Something went wrong, we could not figure out which move in order to loose");
                }
            } else if (s.equalsIgnoreCase("Y")) {
                me = them;
            } else if (s.equalsIgnoreCase("Z")) {
                if (them == Shape.P) {
                    me = Shape.S;
                } else if (them == Shape.R) {
                    me = Shape.P;
                } else if (them == Shape.S) {
                    me = Shape.R;
                } else {
                    throw new IllegalStateException("Something went wrong, we could not figure out which move in order to win");
                }
            } else {
                throw new IllegalStateException("Something went wrong, there is an/are unmatched input in: " + Arrays.toString(splitShapes));
            }
        }
        shapes.put(them, me);
        return shapes;
    }
}
