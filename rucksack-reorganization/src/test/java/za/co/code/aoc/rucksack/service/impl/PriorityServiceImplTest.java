package za.co.code.aoc.rucksack.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PriorityServiceImplTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getPriority() {
        int priority = PriorityServiceImpl.getInstance().getPriority('a');
        Assertions.assertEquals(1, priority);
    }
}