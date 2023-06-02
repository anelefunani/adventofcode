package za.co.code.aoc.rucksack.service.impl;

import za.co.code.aoc.rucksack.domain.*;
import za.co.code.aoc.rucksack.service.DuplicationService;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicationServiceDay2 implements DuplicationService {

    private Map<Badge, Integer> groups;

    public DuplicationServiceDay2() {
        groups = new HashMap<>();
    }

    @Override
    public Duplicates getDuplicates(Rucksacks rucksacks) {

        for (int i = 0; i < rucksacks.getValue().size(); i = i + 3) {
            List<Rucksack> rucksacks1 = rucksacks.getValue().subList(i, i + 3);
            final Set<Character> uniqueItems = new HashSet<>();
            for (Rucksack r : rucksacks1) {
                for (Character c : r.getRucksack().toCharArray()) {
                    uniqueItems.add(c);
                }

                for (Character c : uniqueItems) {
                    if (rucksacks1.get(0).getRucksack().indexOf(c) > -1
                            && rucksacks1.get(1).getRucksack().indexOf(c) > -1
                            && rucksacks1.get(2).getRucksack().indexOf(c) > -1) {
                        groups.put(ImmutableBadge.of(c), Optional.ofNullable(groups.get(ImmutableBadge.of(c))).orElse(0) + 1);
                    }
                }
            }
        }

        List<Duplicate> duplicates = groups.keySet().stream().map(Badge::getValue).map(b -> ImmutableDuplicate.builder()
                        .duplicate(b)
                        .priority(PriorityServiceImpl.getInstance().getPriority(b) * (groups.get(ImmutableBadge.of(b)) / 3))
                        .build())
                .collect(Collectors.toList());

        return ImmutableDuplicates.of(duplicates);
    }

    Map<Badge, Integer> getGroups() {
        return this.groups;
    }
}
