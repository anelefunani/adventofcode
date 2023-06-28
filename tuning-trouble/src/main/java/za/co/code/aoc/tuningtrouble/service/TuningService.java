package za.co.code.aoc.tuningtrouble.service;

import za.co.code.aoc.tuningtrouble.domain.MarkerIndex;
import za.co.code.aoc.tuningtrouble.domain.SignalIndex;

public interface TuningService {

    MarkerIndex tune(SignalIndex signalIndex);
}
