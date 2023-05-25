package za.co.code.aoc.caloriecounting.adapters.impl;

import za.co.code.aoc.caloriecounting.domain.value.ImmutableCalories;
import za.co.code.aoc.caloriecounting.domain.values.Elves;
import za.co.code.aoc.caloriecounting.domain.values.ImmutableElf;
import za.co.code.aoc.caloriecounting.domain.values.ImmutableElves;
import za.co.code.aoc.caloriecounting.adapters.Adapter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RawToElvesAdapter implements Adapter<Elves, byte[]> {

    @Override
    public Elves adapt(byte[] rawCalories) {

        String strCalories = new String(rawCalories);

        List<String> lstCalories = Arrays.stream(strCalories.split("\r\n")).collect(Collectors.toList());

        ImmutableElves.Builder elvesBuilder = ImmutableElves.builder();

        ImmutableElf.Builder elfBuilder = ImmutableElf.builder();

        for (String calories : lstCalories) {
            if (calories.isEmpty()) {
                elvesBuilder.addElves(elfBuilder.build());
                elfBuilder = ImmutableElf.builder();
                continue;
            }
            elfBuilder.addCalories(ImmutableCalories.of(Integer.parseInt(calories)));
        }

        elvesBuilder.addElves(elfBuilder.build());

        return elvesBuilder.build();
    }
}
