package za.co.code.aoc.supplystacks.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.supplystacks.dao.SupplyStacksSummaryDao;
import za.co.code.aoc.supplystacks.dao.SupplyStacksDao;
import za.co.code.aoc.supplystacks.domain.*;

import java.util.*;

class SupplyStacksSummaryDaoImplTest {

    private SupplyStacksDao supplyStacksInfoDao;

    private SupplyStacksSummaryDao stackInfoDao;

    @BeforeEach
    void setUp() {
        supplyStacksInfoDao = new SupplyStacksDaoImpl("src/test/resources/input.data");
        stackInfoDao = new SupplyStacksSummaryDaoImpl(supplyStacksInfoDao);
    }

    @Test
    void getStackInformation() {
        StackInfo stackInfo = stackInfoDao.getSupplyStacksSummary();
        Assertions.assertEquals(ImmutableNumberOfStacks.of(3), stackInfo.getNumberOfStacks());
        Assertions.assertEquals(ImmutableStackIndexes.of(new Integer[] {1, 2, 3}), stackInfo.getStackIndexes());
        Assertions.assertEquals(ImmutableStartOfInstructionsIndex.of(5), stackInfo.getStartOfInstructionsIndex());
        Assertions.assertEquals(ImmutableStartOfStacksIndex.of(2), stackInfo.getStartOfStacksIndex());
        Assertions.assertEquals(4, stackInfo.getInstructions().getInstructions().size());
        String[] crates = new String[]{"N", "Z"};
        Arrays.stream(crates).forEach(x -> Assertions.assertEquals(x, stackInfo.getStacks().getValue().get(0).getCrates().pop().getCrateLabel().getValue()));
        Assertions.assertEquals(0, stackInfo.getStacks().getValue().get(0).getCrates().size());
    }
}
