package za.co.code.aoc.tuningtrouble.controller;

import za.co.code.aoc.tuningtrouble.domain.ImmutableSignalIndex;
import za.co.code.aoc.tuningtrouble.service.TuningService;

public class TuningTroubleController {

    private final TuningService tuningService;

    public TuningTroubleController(TuningService tuningService) {
        this.tuningService = tuningService;
    }

    public int getMarkerIndex() {
        return tuningService.tune(ImmutableSignalIndex.of(0)).getValue();
    }
}
