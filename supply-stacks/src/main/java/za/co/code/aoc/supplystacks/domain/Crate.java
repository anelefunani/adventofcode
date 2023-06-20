package za.co.code.aoc.supplystacks.domain;

import org.immutables.value.Value;

@Value.Immutable
public interface Crate {

    @Value.Parameter
    CrateLabel getCrateLabel();
}
