package za.co.code.aoc.tuningtrouble.adapter.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.tuningtrouble.adapter.Adapter;
import za.co.code.aoc.tuningtrouble.domain.ImmutableSignal;
import za.co.code.aoc.tuningtrouble.domain.Signals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class RawToSignalsAdapterTest {

    private Adapter<Signals, byte[]> rawToSignals;

    @BeforeEach
    void setUp() {

        rawToSignals = new RawToSignalsAdapter();
    }

    @Test
    void adapt() throws IOException {

        Signals signals = rawToSignals.adapt(Files.readAllBytes(Paths.get("src/test/resources/input.data")));

        Assertions.assertEquals(ImmutableSignal.of("bvwbjplbgvbhsrlpgdmjqwftvncz"), signals.getSignal(0));

        Assertions.assertEquals(ImmutableSignal.of("nppdvjthqldpwncqszvftbrmjlhg"), signals.getSignal(1));

        Assertions.assertEquals(ImmutableSignal.of("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"), signals.getSignal(2));

        Assertions.assertEquals(ImmutableSignal.of("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"), signals.getSignal(3));

    }

}
