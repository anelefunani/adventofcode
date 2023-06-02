package za.co.code.aoc.rucksack.adaptor;

public interface Adaptor <R, T> {

    R adapt(T fromType);
}
