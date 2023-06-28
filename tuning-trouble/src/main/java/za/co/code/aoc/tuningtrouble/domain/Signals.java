package za.co.code.aoc.tuningtrouble.domain;

import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
public interface Signals {

    List<Signal> getSignal();

    default Signal getSignal(Integer idx) {
        return getSignal().get(idx);
    }
}
