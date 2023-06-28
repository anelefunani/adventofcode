package za.co.code.aoc.tuningtrouble.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.tuningtrouble.dao.TuningTroubleDao;
import za.co.code.aoc.tuningtrouble.domain.Signals;

class TuningTroubleDaoImplTest {

    private static final String FILE_LOCATION = "src/test/resources/input.data";

    private TuningTroubleDao tuningTroubleDao;

    @BeforeEach
    void setUp() {

        tuningTroubleDao = new TuningTroubleDaoImpl(FILE_LOCATION);
    }

    @Test
    void getTuningTrouble() {

        Signals signals = tuningTroubleDao.getSignals();

        Assertions.assertEquals(5, signals.getSignal().size());
    }

}
