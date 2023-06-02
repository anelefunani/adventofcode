package za.co.code.aoc.rucksack.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.rucksack.dao.RucksackDao;
import za.co.code.aoc.rucksack.domain.Rucksacks;

class RucksackDaoImplTest {

    private RucksackDao rucksackDao;

    @BeforeEach
    void setUp() {
        rucksackDao = new RucksackDaoImpl("src/test/resources/input.data");
    }

    @Test
    void getRucksacks() {
        Rucksacks rucksacks = rucksackDao.getRucksacks();
        Assertions.assertNotNull(rucksacks);
        Assertions.assertEquals(6, rucksacks.getValue().size());
    }
}