package za.co.code.aoc.rucksack.adaptor.impl;

import za.co.code.aoc.rucksack.adaptor.Adaptor;
import za.co.code.aoc.rucksack.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class RawToRucksacks implements Adaptor<Rucksacks, List<String>> {

    @Override
    public Rucksacks adapt(List<String> rawRucksacks) {

        ImmutableRucksacks.Builder rucksacksBuilder = ImmutableRucksacks.builder();

        List<Rucksack> rucksacks = rawRucksacks.stream()
                .map(String::trim)
                .map(r -> r.replace("\n", ""))
                .map(r -> r.replace("\r", ""))
                .map(r -> {
                    ImmutableRucksack rucksack = ImmutableRucksack.builder()
                            .rucksack(r)
                            .build();
                    rucksacksBuilder.addValue(rucksack);
                    return rucksack;
                }).collect(Collectors.toList());

        return ImmutableRucksacks.of(rucksacks);
    }
}
