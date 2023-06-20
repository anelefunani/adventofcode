package za.co.code.aoc.supplystacks.domain;

import org.immutables.value.Value;

@Value.Immutable
public interface Instruction {
    NumberOfMoves getNumberOfMoves();
    From getFrom();
    To getTo();
}
