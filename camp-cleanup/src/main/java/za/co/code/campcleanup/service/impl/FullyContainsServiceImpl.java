package za.co.code.campcleanup.service.impl;

import za.co.code.campcleanup.domain.*;
import za.co.code.campcleanup.service.ContainsCounterService;

import java.util.*;

public class FullyContainsServiceImpl implements ContainsCounterService {

    @Override
    public FullyContains count(SectionPairs sectionPairs) {
        ImmutableFullyContains.Builder fullyContains = ImmutableFullyContains.builder();
        fullyContains.value(0);
        List<SectionPair> sectionPairList = sectionPairs.getValue();
        sectionPairList.forEach(sectionPair -> {
            Section sectionOne = sectionPair.getSectionOne();
            Section sectionTwo = sectionPair.getSectionTwo();
            if (fullyContains(sectionOne, sectionTwo) || fullyContains(sectionTwo, sectionOne)) {
                fullyContains.value(ImmutableFullyContains.copyOf(fullyContains.build()).getValue() + 1);
            }
        });
        return fullyContains.build();
    }

    private boolean fullyContains(Section a, Section b) {
        return a.getStart() >= b.getStart()  && a.getEnd() <= b.getEnd();
    }
}
