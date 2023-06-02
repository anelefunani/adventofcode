package za.co.code.aoc.rucksack.adaptor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.rucksack.adaptor.impl.RawToRucksacks;
import za.co.code.aoc.rucksack.domain.Rucksacks;

import java.util.ArrayList;
import java.util.List;

class RawToRucksacksTest {

    private Adaptor<Rucksacks, List<String>> rucksacksAdaptor;

    @BeforeEach
    void setUp() {
        rucksacksAdaptor = new RawToRucksacks();
    }

    @Test
    void adapt() {
        List<String> test = new ArrayList<>();

        test.add("vJrwpWtwJgWrhcsFMMfFFhFp");
        test.add("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL");
        test.add("PmmdzqPrVvPwwTWBwg");
        test.add("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn");
        test.add("ttgJtRGJQctTZtZT");
        test.add("CrZsJsPPZsGzwwsLwLmpwMDw");

        Rucksacks actual = rucksacksAdaptor.adapt(test);

        Assertions.assertEquals(6, actual.getValue().size());
        Assertions.assertEquals("vJrwpWtwJgWr", actual.getValue().get(0).firstCompartment().getValue());
        Assertions.assertEquals("hcsFMMfFFhFp", actual.getValue().get(0).secondCompartment().getValue());
    }
}