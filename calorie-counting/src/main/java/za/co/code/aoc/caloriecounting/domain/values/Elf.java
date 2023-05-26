package za.co.code.aoc.caloriecounting.domain.values;

import org.immutables.value.Value;
import za.co.code.aoc.caloriecounting.domain.value.Calories;

import java.util.List;

@Value.Immutable
public interface Elf {

    List<Calories> getCalories();
}
