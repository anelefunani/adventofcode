package za.co.code.aoc.tuningtrouble.service.impl;

import za.co.code.aoc.tuningtrouble.domain.MarkerIndex;
import za.co.code.aoc.tuningtrouble.domain.SignalIndex;
import za.co.code.aoc.tuningtrouble.service.TuningService;

public class TuningServiceComplex extends TuningServiceSimple implements TuningService {

    public TuningServiceComplex(String fileLocation) {
        super(fileLocation);
    }

    @Override
    public MarkerIndex tune(SignalIndex signalIndex) {
        return getMarkerIndex(signalIndex);
    }

    @Override
    protected int getBufferIdx(String signal) {
        int start = 0;
        int i;
        for(i = 13; i < signal.length(); i++) {
            String buffer = signal.substring(start, start + 14);
            if (buffer.matches("^(?:([A-Za-z])(?!.*\\1))*$")) {
                break;
            }
            start++;
        }
        return (i + 1);
    }
}
