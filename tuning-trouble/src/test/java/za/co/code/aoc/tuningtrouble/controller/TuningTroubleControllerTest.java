package za.co.code.aoc.tuningtrouble.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.tuningtrouble.service.TuningService;
import za.co.code.aoc.tuningtrouble.service.impl.TuningServiceSimple;

class TuningTroubleControllerTest {

    private TuningTroubleController tuningTroubleController;

    private TuningService tuningService;


    @BeforeEach
    void setUp() {
        tuningService = new TuningServiceSimple("src/test/resources/input.data");
        tuningTroubleController = new TuningTroubleController(tuningService);
    }

    @Test
    void getMarkerIndex() {
        Assertions.assertEquals(7, tuningTroubleController.getMarkerIndex());
    }

}