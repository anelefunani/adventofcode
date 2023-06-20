package za.co.code.aoc.supplystacks.domain;

import org.immutables.value.Value;

import java.util.ArrayDeque;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Value.Immutable
public interface StackInfo {

    NumberOfStacks getNumberOfStacks();

    StackIndexes getStackIndexes();

    StartOfInstructionsIndex getStartOfInstructionsIndex();

    StartOfStacksIndex getStartOfStacksIndex();

    @Value.Default
    default Stacks getStacks() {
        return ImmutableStacks.of(IntStream.range(0, getNumberOfStacks().getValue())
                .mapToObj(idx -> {
                    ArrayDeque<Crate> crates = new ArrayDeque<>();
                    return ImmutableStack.of(crates);
                })
                .collect(Collectors.toList()));
    }

    Instructions getInstructions();
}
