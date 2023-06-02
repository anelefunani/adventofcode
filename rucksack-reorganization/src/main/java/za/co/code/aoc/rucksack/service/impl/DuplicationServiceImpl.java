package za.co.code.aoc.rucksack.service.impl;

import za.co.code.aoc.rucksack.domain.Duplicates;
import za.co.code.aoc.rucksack.domain.ImmutableDuplicate;
import za.co.code.aoc.rucksack.domain.ImmutableDuplicates;
import za.co.code.aoc.rucksack.domain.Rucksacks;
import za.co.code.aoc.rucksack.service.DuplicationService;

public class DuplicationServiceImpl implements DuplicationService {

    @Override
    public Duplicates getDuplicates(Rucksacks rucksacks) {
        int count = 0;
        ImmutableDuplicates.Builder duplicatesBuilder = ImmutableDuplicates.builder();
        for (int i = 0; i < rucksacks.getValue().size(); i++) {
               String firstCompartment = rucksacks.getValue().get(i).firstCompartment().getValue();
               for (char c : rucksacks.getValue().get(i).secondCompartment().getValue().toCharArray()) {
                   if (duplicateIndex(c, firstCompartment) > -1) {
                       duplicatesBuilder.addValue(ImmutableDuplicate.builder()
                               .duplicate(c)
                               .priority(PriorityServiceImpl.getInstance().getPriority(c))
                               .build());
                       count++;
                       break;
                   }
               }
           }
        System.out.println("Number of duplicates: " + count);
        return duplicatesBuilder.build();
    }

    private int duplicateIndex(char c, String s) {
        return s.indexOf(c);
    }
}
