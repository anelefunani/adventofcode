package za.co.code.aoc.caloriecounting.adapters.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.caloriecounting.adapters.Adapter;
import za.co.code.aoc.caloriecounting.domain.values.Elves;

import java.nio.charset.StandardCharsets;

class RawToElvesAdapterTest {

    private Adapter<Elves, byte[]> adapter;

    @BeforeEach
    void setUp() {
        adapter = new RawToElvesAdapter();
    }

    @Test
    void shouldAdaptToElves() {
        final String data = "1000\r\n"
                + "2000\r\n"
                + "3000\r\n"
                + "\r\n"
                + "4000\r\n";

        final byte[] rawData = data.getBytes(StandardCharsets.UTF_8);

        Elves elves = adapter.adapt(rawData);

        Assertions.assertNotNull(elves);
        Assertions.assertEquals(2, elves.getElves().size());
    }
}