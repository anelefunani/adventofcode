package za.co.code.aoc.supplystacks.domain;

import org.immutables.value.Value;

import java.util.List;
import java.util.Optional;

@Value.Immutable
public interface CrateStacks {

    @Value.Parameter
    Optional<List<Stack>> getStacks();

    default NumberOfStacks numberOfStacks() {
        return ImmutableNumberOfStacks.of(getStacks()
                .map(List::size)
                .orElse(0));
    }

    default Stack getStackAt(StackIndex crateIndex) {
        return getStacks()
                .map(x -> x.get(crateIndex.getValue()))
                .orElseThrow(() -> new IllegalStateException("Something went wrong, we could not find a stack at index: " + crateIndex));
    }
}
