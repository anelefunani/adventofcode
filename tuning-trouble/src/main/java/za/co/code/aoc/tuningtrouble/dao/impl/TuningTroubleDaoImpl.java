package za.co.code.aoc.tuningtrouble.dao.impl;

import za.co.code.aoc.tuningtrouble.adapter.Adapter;
import za.co.code.aoc.tuningtrouble.adapter.impl.RawToSignalsAdapter;
import za.co.code.aoc.tuningtrouble.dao.TuningTroubleDao;
import za.co.code.aoc.tuningtrouble.domain.Signals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TuningTroubleDaoImpl implements TuningTroubleDao {

    private final String fileLocation;
    private final Adapter<Signals, byte[]> rawToSignals;

    public TuningTroubleDaoImpl(String fileLocation) {

        this.fileLocation = fileLocation;

        this.rawToSignals = new RawToSignalsAdapter();
    }

    @Override
    public Signals getSignals() {

        try {
            return rawToSignals.adapt(Files.readAllBytes(Paths.get(fileLocation)));
        } catch (IOException e) {
            throw new IllegalStateException("Something went wrong, we could not read file at: " + fileLocation);
        }
    }

}
