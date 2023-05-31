package za.co.code.aoc.rockpaperscissors.adaptor.impl;

import za.co.code.aoc.rockpaperscissors.adaptor.Adaptor;
import za.co.code.aoc.rockpaperscissors.domain.enums.Shape;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RawToShapesDay1 implements Adaptor<String, Map<Shape, Shape>> {

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
                me = Shape.R;
            } else if (s.equalsIgnoreCase("Y")) {
                me = Shape.P;
            } else if (s.equalsIgnoreCase("Z")) {
                me = Shape.S;
            } else {
                throw new IllegalStateException("Something went wrong, there is an/are unmatched input in: " + Arrays.toString(splitShapes));
            }
        }
        shapes.put(them, me);
        return shapes;
    }
}
