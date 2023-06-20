package za.co.code.aoc.supplystacks.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.supplystacks.dao.SupplyStacksSummaryDao;
import za.co.code.aoc.supplystacks.dao.SupplyStacksDao;
import za.co.code.aoc.supplystacks.dao.impl.SupplyStacksSummaryDaoImpl;
import za.co.code.aoc.supplystacks.dao.impl.SupplyStacksDaoImpl;
import za.co.code.aoc.supplystacks.domain.ImmutableTopCrates;
import za.co.code.aoc.supplystacks.domain.TopCrates;
import za.co.code.aoc.supplystacks.service.SupplyStacksService;

class SupplyStacksServiceSimpleTest {

    private SupplyStacksSummaryDao stackInfoDao;

    private SupplyStacksDao supplyStacksInfoDao;

    private SupplyStacksService supplyStacksService;

    @BeforeEach
    void setUp() {
        supplyStacksInfoDao = new SupplyStacksDaoImpl("src/test/resources/input.data");
        stackInfoDao = new SupplyStacksSummaryDaoImpl(supplyStacksInfoDao);
        supplyStacksService = new SupplyStacksServiceSimple(stackInfoDao);
    }

    @Test
    void getTopCrates() {
        TopCrates topCrates = supplyStacksService.getTopCrates();
        Assertions.assertEquals(ImmutableTopCrates.of("CMZ"), topCrates);
    }
}