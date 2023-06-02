package za.co.code.aoc.rucksack.domain;

import org.immutables.value.Value;

@Value.Immutable
public interface Duplicate {
    Character getDuplicate();
    Integer getPriority();
}
