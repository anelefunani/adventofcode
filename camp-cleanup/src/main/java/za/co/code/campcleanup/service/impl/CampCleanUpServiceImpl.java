package za.co.code.campcleanup.service.impl;

import za.co.code.campcleanup.adapter.Adapter;
import za.co.code.campcleanup.adapter.impl.RawToSectionPairs;
import za.co.code.campcleanup.dao.CampCleanUpDao;
import za.co.code.campcleanup.domain.Count;
import za.co.code.campcleanup.domain.SectionPairs;
import za.co.code.campcleanup.service.CampCleanUpService;
import za.co.code.campcleanup.service.ContainsCounterService;

public class CampCleanUpServiceImpl implements CampCleanUpService {

    private final CampCleanUpDao campCleanUpDao;

    private static final Adapter<SectionPairs, byte[]> adapter = new RawToSectionPairs();

    private final ContainsCounterService containsCounterService;

    public CampCleanUpServiceImpl(CampCleanUpDao campCleanUpDao,
                                  ContainsCounterService containsCounterService) {
        this.campCleanUpDao = campCleanUpDao;
        this.containsCounterService = containsCounterService;
    }

    @Override
    public Count cleanup() {
        return containsCounterService.count(adapter.adapt(campCleanUpDao.getCampCleanUp()));
    }
}
