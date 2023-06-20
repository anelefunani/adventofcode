package za.co.code.aoc.supplystacks.domain;

import org.immutables.value.Value;

import java.util.Deque;

@Value.Immutable
public interface Stack {

    @Value.Parameter
    Deque<Crate> getCrates();

    default NumberOfCrates getNumberOfCrates() {
        return ImmutableNumberOfCrates.of(getCrates().size());
    }
}
