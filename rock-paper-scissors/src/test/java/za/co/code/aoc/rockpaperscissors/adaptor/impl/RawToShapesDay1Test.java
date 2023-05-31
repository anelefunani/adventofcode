package za.co.code.aoc.rockpaperscissors.adaptor.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.rockpaperscissors.domain.enums.Shape;

import java.util.HashMap;
import java.util.Map;

class RawToShapesDay1Test {

    private RawToShapesDay1 rawToShapesDay1;
    
    @BeforeEach
    void setUp() {
        rawToShapesDay1 = new RawToShapesDay1();
    }
    
    @Test
    void adapt_A_Y() {
        Map<Shape, Shape> actualResults = rawToShapesDay1.adapt("A Y");
        Map<Shape, Shape> expectedShapes = new HashMap<>();
        expectedShapes.put(Shape.R, Shape.P);
        Assertions.assertEquals(expectedShapes, actualResults);
    }

    @Test
    void adapt_B_X() {
        Map<Shape, Shape> actualResults = rawToShapesDay1.adapt("B X");
        Map<Shape, Shape> expectedShapes = new HashMap<>();
        expectedShapes.put(Shape.P, Shape.R);
        Assertions.assertEquals(expectedShapes, actualResults);
    }

    @Test
    void adapt_C_Z() {
        Map<Shape, Shape> actualResults = rawToShapesDay1.adapt("C Z");
        Map<Shape, Shape> expectedShapes = new HashMap<>();
        expectedShapes.put(Shape.S, Shape.S);
        Assertions.assertEquals(expectedShapes, actualResults);
    }
}