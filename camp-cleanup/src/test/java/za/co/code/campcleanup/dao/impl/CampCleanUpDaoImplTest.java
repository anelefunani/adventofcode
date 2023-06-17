package za.co.code.campcleanup.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.campcleanup.dao.CampCleanUpDao;

class CampCleanUpDaoImplTest {

    private CampCleanUpDao campCleanUpDao;

    @BeforeEach
    void setUp() {
        final String fileLocation = "src/test/resources/input.data";
        campCleanUpDao = new CampCleanUpDaoImpl(fileLocation);
    }

    @Test
    void getCampCleanUp() {
        byte[] campCleanUp = campCleanUpDao.getCampCleanUp();
        Assertions.assertNotNull(campCleanUp);
    }
}