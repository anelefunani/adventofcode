package za.co.code.aoc.rucksack.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.rucksack.dao.RucksackDao;
import za.co.code.aoc.rucksack.dao.impl.RucksackDaoImpl;
import za.co.code.aoc.rucksack.domain.ImmutablePrioritiesSum;
import za.co.code.aoc.rucksack.domain.PrioritiesSum;
import za.co.code.aoc.rucksack.service.DuplicationService;
import za.co.code.aoc.rucksack.service.RucksackService;

import static org.junit.jupiter.api.Assertions.*;

class RucksackServiceImplTest {

    private RucksackDao rucksackDao;

    private DuplicationService duplicationService;

    private RucksackService rucksackService;

    @BeforeEach
    void setUp() {
        rucksackDao = new RucksackDaoImpl("src/test/resources/input.data");
        duplicationService = new DuplicationServiceImpl();
        rucksackService = new RucksackServiceImpl(rucksackDao, duplicationService);
    }

    @Test
    void reorganise_Day1() {
        PrioritiesSum prioritiesSum = rucksackService.reorganise();
        Assertions.assertEquals(ImmutablePrioritiesSum.of(157), prioritiesSum);
    }

    @Test
    void reorganise_Day2() {
        duplicationService = new DuplicationServiceDay2();
        rucksackService = new RucksackServiceImpl(rucksackDao, duplicationService);
        PrioritiesSum prioritiesSum = rucksackService.reorganise();
        Assertions.assertEquals(ImmutablePrioritiesSum.of(70), prioritiesSum);
    }
}
