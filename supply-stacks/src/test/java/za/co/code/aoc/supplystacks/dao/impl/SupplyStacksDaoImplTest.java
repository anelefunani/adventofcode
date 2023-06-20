package za.co.code.aoc.supplystacks.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.supplystacks.dao.SupplyStacksDao;

class SupplyStacksDaoImplTest {

    private SupplyStacksDao supplyStacksInfoDao;

    @BeforeEach
    void setUp() {
        supplyStacksInfoDao = new SupplyStacksDaoImpl("src/test/resources/input.data");
    }

    @Test
    void getSupplyStacks() {
        Assertions.assertNotNull(supplyStacksInfoDao.getSupplyStacks());
    }
}
