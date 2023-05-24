package za.co.code.aoc.caloriecouting.services.impl;

import za.co.code.aoc.caloriecouting.dao.CaloriesDao;
import za.co.code.aoc.caloriecouting.domain.value.*;
import za.co.code.aoc.caloriecouting.domain.values.Elf;
import za.co.code.aoc.caloriecouting.domain.values.Elves;
import za.co.code.aoc.caloriecouting.domain.values.ImmutableElf;
import za.co.code.aoc.caloriecouting.services.CaloriesService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CaloriesServiceImpl implements CaloriesService {


    private static final int TOP_THREE = 3;

    private final CaloriesDao caloriesDao;

    public CaloriesServiceImpl(CaloriesDao caloriesDao) {
        this.caloriesDao = caloriesDao;
    }

    @Override
    public MostCalories getMostCalories() {
        return getMostCalories(getTotalCaloriesPerElfOrderedByCaloriesAsc(getElves()));
    }

    @Override
    public TopMostCalories getTopMostCalories() {
        return getTopMostCalories(getTotalCaloriesPerElfOrderedByCaloriesAsc(getElves()));
    }

    private Elves getElves() {
        return caloriesDao.getElves();
    }

    private List<Elf> getTotalCaloriesPerElfOrderedByCaloriesAsc(Elves elves) {
        return elves.getElves()
                .stream()
                .map(elf -> elf.getCalories()
                        .stream()
                        .reduce(ImmutableCalories.of(0), (x, y) ->
                                ImmutableCalories.of(x.getValue() + y.getValue())))
                .map(totalCalories -> ImmutableElf.builder().
                        addCalories(ImmutableCalories.of(totalCalories.getValue())).build())
                .sorted(Comparator.comparing(elf -> elf.getCalories().get(0).getValue())).collect(Collectors.toList());
    }

    private MostCalories getMostCalories(List<Elf> elves) {
        return ImmutableMostCalories.of(elves.get(elves.size() - 1).getCalories().get(0).getValue());
    }

    private TopMostCalories getTopMostCalories(List<Elf> elves) {

        return ImmutableTopMostCalories.of(elves.subList(elves.size() - TOP_THREE, elves.size()).stream().reduce(ImmutableElf.builder()
                .calories(Collections.singletonList(ImmutableCalories.of(0)))
                .build(), (x, y) -> ImmutableElf.builder()
                .calories(Collections.singletonList(ImmutableCalories.of(x.getCalories().get(0).getValue() + y.getCalories().get(0).getValue())))
                .build()).getCalories().get(0).getValue());
    }
}
