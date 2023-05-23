package za.co.code.aoc.caloriecouting.domain.values;

import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
public interface Elves {

    List<Elf> getElves();
}
