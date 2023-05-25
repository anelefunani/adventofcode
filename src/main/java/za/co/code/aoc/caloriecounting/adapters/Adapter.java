package za.co.code.aoc.caloriecounting.adapters;

public interface Adapter<R, T> {

    R adapt(T fromType);
}
