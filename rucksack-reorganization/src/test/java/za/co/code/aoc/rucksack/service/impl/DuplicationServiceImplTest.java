package za.co.code.aoc.rucksack.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.rucksack.dao.RucksackDao;
import za.co.code.aoc.rucksack.dao.impl.RucksackDaoImpl;
import za.co.code.aoc.rucksack.domain.Duplicates;
import za.co.code.aoc.rucksack.service.DuplicationService;

class DuplicationServiceImplTest {

    private static final RucksackDao rucksackDao = new RucksackDaoImpl("src/test/resources/input.data");

    private DuplicationService duplicationService;

    @BeforeEach
    void setUp() {
        duplicationService = new DuplicationServiceImpl();
    }

    @Test
    void getDuplicates() {
        Duplicates duplicates = duplicationService.getDuplicates(rucksackDao.getRucksacks());
        Assertions.assertNotNull(duplicates);
        Assertions.assertEquals(6, duplicates.getValue().size());
    }
}