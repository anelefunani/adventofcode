package za.co.code.aoc.rockpaperscissors.adaptor.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.rockpaperscissors.domain.enums.Shape;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RawToShapesDay2Test {

    private RawToShapesDay2 rawToShapesDay2;

    @BeforeEach
    void setUp() {
        rawToShapesDay2 = new RawToShapesDay2();
    }

    @Test
    void adapt_A_Y() {
        Map<Shape, Shape> actualResults = rawToShapesDay2.adapt("A Y");
        Map<Shape, Shape> expectedShapes = new HashMap<>();
        expectedShapes.put(Shape.R, Shape.R);
        Assertions.assertEquals(expectedShapes, actualResults);
    }

    @Test
    void adapt_B_X() {
        Map<Shape, Shape> actualResults = rawToShapesDay2.adapt("B X");
        Map<Shape, Shape> expectedShapes = new HashMap<>();
        expectedShapes.put(Shape.P, Shape.R);
        Assertions.assertEquals(expectedShapes, actualResults);
    }

    @Test
    void adapt_C_Z() {
        Map<Shape, Shape> actualResults = rawToShapesDay2.adapt("C Z");
        Map<Shape, Shape> expectedShapes = new HashMap<>();
        expectedShapes.put(Shape.S, Shape.R);
        Assertions.assertEquals(expectedShapes, actualResults);
    }
}