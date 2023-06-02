package za.co.code.aoc.rucksack.service.impl;

import za.co.code.aoc.rucksack.dao.RucksackDao;
import za.co.code.aoc.rucksack.domain.*;
import za.co.code.aoc.rucksack.service.DuplicationService;
import za.co.code.aoc.rucksack.service.RucksackService;

public class RucksackServiceImpl implements RucksackService {

    private final RucksackDao rucksackDao;

    private final DuplicationService duplicationService;

    public RucksackServiceImpl(RucksackDao rucksackDao, DuplicationService duplicationService) {
        this.rucksackDao = rucksackDao;
        this.duplicationService = duplicationService;
    }

    @Override
    public PrioritiesSum reorganise() {
        Duplicates duplicates = duplicationService.getDuplicates(rucksackDao.getRucksacks());
        Integer totalPriorities = duplicates.getValue().stream()
                .map(Duplicate::getPriority)
                .reduce(0, Integer::sum);

        return ImmutablePrioritiesSum.of(totalPriorities);
    }
}
