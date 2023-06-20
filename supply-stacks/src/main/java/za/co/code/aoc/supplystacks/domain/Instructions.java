package za.co.code.aoc.supplystacks.domain;

import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
public interface Instructions {

    List<Instruction> getInstructions();
}
