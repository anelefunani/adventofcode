package za.co.code.aoc.supplystacks.adapter;

public interface Adapter <T, R> {

    R adapt(T from);
}
