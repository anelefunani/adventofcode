package za.co.code.aoc.tuningtrouble.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.tuningtrouble.domain.ImmutableMarkerIndex;
import za.co.code.aoc.tuningtrouble.domain.ImmutableSignalIndex;
import za.co.code.aoc.tuningtrouble.service.TuningService;

import static org.junit.jupiter.api.Assertions.*;

class TuningServiceComplexTest {

    private TuningService tuningService;

    @BeforeEach
    void setUp() {
        tuningService = new TuningServiceComplex("src/test/resources/input.data");
    }

    @Test
    void tune() {
        Assertions.assertEquals(ImmutableMarkerIndex.of(19), tuningService.tune(ImmutableSignalIndex.of(0)));
        Assertions.assertEquals(ImmutableMarkerIndex.of(23), tuningService.tune(ImmutableSignalIndex.of(1)));
        Assertions.assertEquals(ImmutableMarkerIndex.of(23), tuningService.tune(ImmutableSignalIndex.of(2)));
        Assertions.assertEquals(ImmutableMarkerIndex.of(29), tuningService.tune(ImmutableSignalIndex.of(3)));
        Assertions.assertEquals(ImmutableMarkerIndex.of(26), tuningService.tune(ImmutableSignalIndex.of(4)));
    }
}