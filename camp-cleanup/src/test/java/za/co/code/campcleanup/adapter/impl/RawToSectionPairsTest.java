package za.co.code.campcleanup.adapter.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.campcleanup.adapter.Adapter;
import za.co.code.campcleanup.dao.CampCleanUpDao;
import za.co.code.campcleanup.dao.impl.CampCleanUpDaoImpl;
import za.co.code.campcleanup.domain.SectionPairs;

class RawToSectionPairsTest {

    private CampCleanUpDao dao;

    private Adapter<SectionPairs, byte[]> adapter;

    @BeforeEach
    void setUp() {
        String fileLocation = "src/test/resources/input.data";
        dao = new CampCleanUpDaoImpl(fileLocation);
        adapter = new RawToSectionPairs();
    }

    @Test
    void adapt() {
        SectionPairs retVal = adapter.adapt(dao.getCampCleanUp());
        Assertions.assertNotNull(retVal);
        Assertions.assertEquals(6, retVal.getValue().size());
    }
}