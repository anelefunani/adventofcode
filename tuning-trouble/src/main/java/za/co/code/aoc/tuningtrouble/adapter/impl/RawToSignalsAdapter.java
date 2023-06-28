package za.co.code.aoc.tuningtrouble.adapter.impl;

import za.co.code.aoc.tuningtrouble.adapter.Adapter;
import za.co.code.aoc.tuningtrouble.domain.ImmutableSignal;
import za.co.code.aoc.tuningtrouble.domain.ImmutableSignals;
import za.co.code.aoc.tuningtrouble.domain.Signals;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RawToSignalsAdapter implements Adapter<Signals, byte[]> {

    @Override
    public Signals adapt(byte[] raw) {

        String rawStr = new String(raw);

        String[] signals = rawStr.replace("\r", "").split("\n");

        return ImmutableSignals.builder()
                .addAllSignal(Arrays.stream(signals)
                        .map(ImmutableSignal::of)
                        .collect(Collectors
                                .toList())
                ).build();
    }

}
