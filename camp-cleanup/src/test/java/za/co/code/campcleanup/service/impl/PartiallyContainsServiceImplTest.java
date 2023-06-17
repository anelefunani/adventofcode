package za.co.code.campcleanup.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.campcleanup.adapter.Adapter;
import za.co.code.campcleanup.adapter.impl.RawToSectionPairs;
import za.co.code.campcleanup.dao.CampCleanUpDao;
import za.co.code.campcleanup.dao.impl.CampCleanUpDaoImpl;
import za.co.code.campcleanup.domain.Count;
import za.co.code.campcleanup.domain.ImmutablePartiallyContains;
import za.co.code.campcleanup.domain.SectionPairs;
import za.co.code.campcleanup.service.ContainsCounterService;

class PartiallyContainsServiceImplTest {

    private ContainsCounterService containsCounterService;

    private CampCleanUpDao campCleanUpDao;

    private Adapter<SectionPairs, byte[]> adapter;

    @BeforeEach
    void setUp() {
        campCleanUpDao = new CampCleanUpDaoImpl("src/test/resources/input.data");
        adapter = new RawToSectionPairs();
        containsCounterService = new PartiallyContainsServiceImpl();
    }

    @Test
    void count() {
        Count partiallyContains = containsCounterService.count(adapter.adapt(campCleanUpDao.getCampCleanUp()));
        Assertions.assertEquals(ImmutablePartiallyContains.of(4), partiallyContains);
    }
}