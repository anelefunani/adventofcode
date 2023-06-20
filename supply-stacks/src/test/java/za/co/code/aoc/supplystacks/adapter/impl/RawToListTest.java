package za.co.code.aoc.supplystacks.adapter.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.supplystacks.adapter.Adapter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class RawToListTest {

    private byte[] bytes;
    private Adapter<byte[], List<String>> rawToList;

    @BeforeEach
    void setUp() throws IOException {
        bytes = Files.readAllBytes(Paths.get("src/test/resources/input.data"));
        rawToList = new RawToList();
    }

    @Test
    void adapt() {
        List<String> lines = rawToList.adapt(bytes);
        Assertions.assertEquals(9, lines.size());
    }

}