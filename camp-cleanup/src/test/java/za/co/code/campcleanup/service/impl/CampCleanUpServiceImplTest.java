package za.co.code.campcleanup.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.campcleanup.dao.CampCleanUpDao;
import za.co.code.campcleanup.dao.impl.CampCleanUpDaoImpl;
import za.co.code.campcleanup.domain.Count;
import za.co.code.campcleanup.domain.ImmutableFullyContains;
import za.co.code.campcleanup.service.CampCleanUpService;
import za.co.code.campcleanup.service.ContainsCounterService;

class CampCleanUpServiceImplTest {

    private CampCleanUpService campCleanupService;

    private CampCleanUpDao campCleanUpDao;

    private ContainsCounterService containsCounterService;

    @BeforeEach
    void setUp() {
        campCleanUpDao = new CampCleanUpDaoImpl("src/test/resources/input.data");
        containsCounterService = new FullyContainsServiceImpl();
        campCleanupService = new CampCleanUpServiceImpl(campCleanUpDao, containsCounterService);
    }

    @Test
    void cleanup() {
        Count fullyContains = campCleanupService.cleanup();
        Assertions.assertEquals(ImmutableFullyContains.of(2), fullyContains);
    }
}
