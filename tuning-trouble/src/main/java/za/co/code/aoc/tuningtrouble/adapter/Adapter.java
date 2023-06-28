package za.co.code.aoc.tuningtrouble.adapter;

public interface Adapter<R, T> {

    R adapt(T fromType);
}
