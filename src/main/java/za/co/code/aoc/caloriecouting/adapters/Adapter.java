package za.co.code.aoc.caloriecouting.adapters;

public interface Adapter<R, T> {

    R adapt(T fromType);
}
