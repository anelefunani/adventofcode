package za.co.code.aoc.supplystacks.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.supplystacks.dao.SupplyStacksSummaryDao;
import za.co.code.aoc.supplystacks.dao.SupplyStacksDao;
import za.co.code.aoc.supplystacks.dao.impl.SupplyStacksSummaryDaoImpl;
import za.co.code.aoc.supplystacks.dao.impl.SupplyStacksDaoImpl;
import za.co.code.aoc.supplystacks.service.SupplyStacksService;
import za.co.code.aoc.supplystacks.service.impl.SupplyStacksServiceSimple;

class SupplyStacksControllerTest {

    private SupplyStacksController supplyStacksController;

    private SupplyStacksService supplyStacksService;

    private SupplyStacksSummaryDao stackInfoDao;

    private SupplyStacksDao supplyStacksInfoDao;

    @BeforeEach
    void setUp() {
        supplyStacksInfoDao = new SupplyStacksDaoImpl("src/test/resources/input.data");
        stackInfoDao = new SupplyStacksSummaryDaoImpl(supplyStacksInfoDao);
        supplyStacksService = new SupplyStacksServiceSimple(stackInfoDao);
        supplyStacksController = new SupplyStacksController(supplyStacksService);
    }

    @Test
    void getTopCrates() {
        String topCrates = supplyStacksController.getTopCrates();
        Assertions.assertEquals("CMZ", topCrates);
    }
}