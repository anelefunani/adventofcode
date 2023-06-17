package za.co.code.campcleanup.adapter;

public interface Adapter <R, T> {
    R adapt(T fromType);
}
