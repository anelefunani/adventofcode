package za.co.code.aoc.caloriecouting.domain;

import org.immutables.value.Value;

public abstract class Wrapper <T> {

    @Value.Parameter
    public abstract T getValue();

    @Override
    public String toString() {
        return getValue().toString();
    }
}