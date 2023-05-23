package za.co.code.aoc.caloriecouting.services.impl;

import za.co.code.aoc.caloriecouting.dao.CaloriesDao;
import za.co.code.aoc.caloriecouting.domain.value.ImmutableCalories;
import za.co.code.aoc.caloriecouting.domain.value.ImmutableMostCalories;
import za.co.code.aoc.caloriecouting.domain.value.MostCalories;
import za.co.code.aoc.caloriecouting.domain.values.Elf;
import za.co.code.aoc.caloriecouting.domain.values.Elves;
import za.co.code.aoc.caloriecouting.domain.values.ImmutableElf;
import za.co.code.aoc.caloriecouting.services.CaloriesService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CaloriesServiceImpl implements CaloriesService {

    private final CaloriesDao caloriesDao;

    public CaloriesServiceImpl(CaloriesDao caloriesDao) {
        this.caloriesDao = caloriesDao;
    }

    @Override
    public MostCalories getMostCalories() {

        Elves elves = caloriesDao.getElves();
        List<Elf> result = elves.getElves()
                .stream()
                .map(elf -> elf.getCalories()
                        .stream()
                        .reduce(ImmutableCalories.of(0), (x, y) ->
                                ImmutableCalories.of(x.getValue() + y.getValue())))
                .map(totalCalories -> ImmutableElf.builder().
                        addCalories(ImmutableCalories.of(totalCalories.getValue())).build())
                .sorted(Comparator.comparing(elf -> elf.getCalories().get(0).getValue())).collect(Collectors.toList());

        return ImmutableMostCalories.of(result.get(result.size() - 1).getCalories().get(0).getValue());
    }
}
