package za.co.code.aoc.rucksack.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.rucksack.dao.RucksackDao;
import za.co.code.aoc.rucksack.dao.impl.RucksackDaoImpl;
import za.co.code.aoc.rucksack.service.DuplicationService;
import za.co.code.aoc.rucksack.service.RucksackService;
import za.co.code.aoc.rucksack.service.impl.DuplicationServiceImpl;
import za.co.code.aoc.rucksack.service.impl.RucksackServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class RucksackControllerTest {

    private RucksackService rucksackService;

    private DuplicationService duplicationService;

    private RucksackDao rucksackDao;

    private RucksackController rucksackController;

    @BeforeEach
    void setUp() {
        rucksackDao = new RucksackDaoImpl("src/test/resources/input.data");
        duplicationService = new DuplicationServiceImpl();
        rucksackService = new RucksackServiceImpl(rucksackDao, duplicationService);
        rucksackController = new RucksackController(rucksackService);
    }

    @Test
    void getPrioritiesSum() {
        int prioritiesSum = rucksackController.getPrioritiesSum();
        Assertions.assertEquals(157, prioritiesSum);
    }
}