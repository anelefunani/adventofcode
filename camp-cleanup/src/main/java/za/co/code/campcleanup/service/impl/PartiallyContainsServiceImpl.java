package za.co.code.campcleanup.service.impl;

import za.co.code.campcleanup.domain.*;
import za.co.code.campcleanup.service.ContainsCounterService;

import java.util.Arrays;
import java.util.List;

public class PartiallyContainsServiceImpl implements ContainsCounterService {
    @Override
    public PartiallyContains count(SectionPairs sectionPairs) {
        ImmutablePartiallyContains.Builder partiallyContainsBuilder = ImmutablePartiallyContains.builder();
        partiallyContainsBuilder.value(0);
        List<SectionPair> sectionPairList = sectionPairs.getValue();
        sectionPairList.forEach(sectionPair -> {
            Section sectionOne = sectionPair.getSectionOne();
            Section sectionTwo = sectionPair.getSectionTwo();
            if (partiallyContains(sectionOne, sectionTwo) || partiallyContains(sectionTwo, sectionOne)) {
                partiallyContainsBuilder.value(ImmutablePartiallyContains.copyOf(partiallyContainsBuilder.build()).getValue() + 1);
            }
        });
        return partiallyContainsBuilder.build();
    }

    private boolean partiallyContains(Section a, Section b) {
        List<Integer> aList = Arrays.asList(a.getPoints());
        List<Integer> bList = Arrays.asList(b.getPoints());
        for (int ai : aList) {
            if (bList.contains(ai)) {
                return true;
            }
        }
        for (int bi : bList) {
            if (aList.contains(bi)) {
                return true;
            }
        }
        return false;
    }
}
