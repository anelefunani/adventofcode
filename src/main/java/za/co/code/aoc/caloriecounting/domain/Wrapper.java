package za.co.code.aoc.caloriecounting.domain;

import org.immutables.value.Value;

public abstract class Wrapper <T> {

    @Value.Parameter
    public abstract T getValue();

    @Override
    public String toString() {
        return getValue().toString();
    }
}
