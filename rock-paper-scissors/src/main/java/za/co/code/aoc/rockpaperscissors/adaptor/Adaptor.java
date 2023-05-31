package za.co.code.aoc.rockpaperscissors.adaptor;

public interface Adaptor <T, R> {
    R adapt(T fromType);
}
