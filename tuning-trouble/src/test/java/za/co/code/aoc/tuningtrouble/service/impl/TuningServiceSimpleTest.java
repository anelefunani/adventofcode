package za.co.code.aoc.tuningtrouble.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.tuningtrouble.domain.ImmutableMarkerIndex;
import za.co.code.aoc.tuningtrouble.domain.ImmutableSignalIndex;

class TuningServiceSimpleTest {

    private TuningServiceSimple tuningService;

    @BeforeEach
    void setUp() {

        this.tuningService = new TuningServiceSimple("src/test/resources/input.data");
    }

    @Test
    void tune() {
        Assertions.assertEquals(ImmutableMarkerIndex.of(7), tuningService.tune(ImmutableSignalIndex.of(0)));
        Assertions.assertEquals(ImmutableMarkerIndex.of(5), tuningService.tune(ImmutableSignalIndex.of(1)));
        Assertions.assertEquals(ImmutableMarkerIndex.of(6), tuningService.tune(ImmutableSignalIndex.of(2)));
        Assertions.assertEquals(ImmutableMarkerIndex.of(10), tuningService.tune(ImmutableSignalIndex.of(3)));
        Assertions.assertEquals(ImmutableMarkerIndex.of(11), tuningService.tune(ImmutableSignalIndex.of(4)));
    }

}