package za.co.code.aoc.rucksack.domain;

import org.immutables.value.Value;

@Value.Immutable
public interface Rucksack {

    @Value.Parameter
    String getRucksack();
    default Compartment firstCompartment() {
        return ImmutableCompartment.builder()
                .value(getRucksack().substring(0, getRucksack().length() / 2))
                .build();
    }
    default Compartment secondCompartment() {
        return ImmutableCompartment.builder()
                .value(getRucksack().substring(getRucksack().length() / 2))
                .build();
    }
}
