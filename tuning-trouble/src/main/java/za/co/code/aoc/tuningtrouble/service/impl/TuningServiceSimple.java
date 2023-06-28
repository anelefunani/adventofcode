package za.co.code.aoc.tuningtrouble.service.impl;

import za.co.code.aoc.tuningtrouble.dao.TuningTroubleDao;
import za.co.code.aoc.tuningtrouble.dao.impl.TuningTroubleDaoImpl;
import za.co.code.aoc.tuningtrouble.domain.ImmutableMarkerIndex;
import za.co.code.aoc.tuningtrouble.domain.MarkerIndex;
import za.co.code.aoc.tuningtrouble.domain.SignalIndex;
import za.co.code.aoc.tuningtrouble.domain.Signals;
import za.co.code.aoc.tuningtrouble.service.TuningService;

public class TuningServiceSimple implements TuningService {

    protected final Signals signals;

    protected final TuningTroubleDao tuningTroubleDao;

    public TuningServiceSimple(String fileLocation) {
        this.tuningTroubleDao = new TuningTroubleDaoImpl(fileLocation);
        this.signals = tuningTroubleDao.getSignals();
    }

    @Override
    public MarkerIndex tune(SignalIndex signalIndex) {
        return getMarkerIndex(signalIndex);
    }

    protected ImmutableMarkerIndex getMarkerIndex(SignalIndex signalIndex) {
        return ImmutableMarkerIndex.of(getBufferIdx(
                getSignals()
                        .getSignal(signalIndex
                                .getValue())
                        .getValue()));
    }

    protected int getBufferIdx(String signal) {
        int start = 0;
        int i;
        for(i = 3; i < signal.length(); i++) {
            String buffer = signal.substring(start, start + 4);
            if (buffer.matches("^(?:([A-Za-z])(?!.*\\1))*$")) {
                break;
            }
            start++;
        }
        return (i + 1);
    }

    protected Signals getSignals() {
        return this.signals;
    }
}
