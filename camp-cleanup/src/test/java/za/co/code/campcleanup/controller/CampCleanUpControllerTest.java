package za.co.code.campcleanup.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.campcleanup.dao.CampCleanUpDao;
import za.co.code.campcleanup.dao.impl.CampCleanUpDaoImpl;
import za.co.code.campcleanup.service.CampCleanUpService;
import za.co.code.campcleanup.service.ContainsCounterService;
import za.co.code.campcleanup.service.impl.CampCleanUpServiceImpl;
import za.co.code.campcleanup.service.impl.FullyContainsServiceImpl;

class CampCleanUpControllerTest {

    private CampCleanUpController campCleanUpController;

    private CampCleanUpDao campCleanUpDao;

    private CampCleanUpService campCleanUpService;

    private ContainsCounterService containsCounterService;

    @BeforeEach
    void setUp() {
        campCleanUpDao = new CampCleanUpDaoImpl("src/test/resources/input.data");
        containsCounterService = new FullyContainsServiceImpl();
        campCleanUpService = new CampCleanUpServiceImpl(campCleanUpDao, containsCounterService);
        campCleanUpController = new CampCleanUpController(campCleanUpService);
    }

    @Test
    void campCleanUp() {
        int numberOfFullyContainedPairs = campCleanUpController.getNumberOfFullyContainedPairs();
        Assertions.assertEquals(2, numberOfFullyContainedPairs);
    }
}