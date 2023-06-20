package za.co.code.aoc.supplystacks.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.supplystacks.dao.impl.SupplyStacksDaoImpl;
import za.co.code.aoc.supplystacks.dao.impl.SupplyStacksSummaryDaoImpl;
import za.co.code.aoc.supplystacks.domain.ImmutableTopCrates;
import za.co.code.aoc.supplystacks.domain.TopCrates;
import za.co.code.aoc.supplystacks.service.SupplyStacksService;

class SupplyStacksServiceComplexTest {

    private SupplyStacksService supplyStacksService;

    @BeforeEach
    void setUp() {
        supplyStacksService = new SupplyStacksServiceComplex(new SupplyStacksSummaryDaoImpl(new SupplyStacksDaoImpl("src/test/resources/input.data")));
    }

    @Test
    void getTopStacks() {
        TopCrates topCrates = supplyStacksService.getTopCrates();
        Assertions.assertEquals(ImmutableTopCrates.of("MCD"), topCrates);
    }

}
