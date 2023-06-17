package za.co.code.campcleanup.domain;

import org.immutables.value.Value;

@Value.Immutable
public interface Section {

    @Value.Parameter
    Integer getStart();

    @Value.Parameter
    Integer getEnd();

    @Value.Default
    default Integer[] getPoints() {
        Integer[] points = new Integer[(getEnd() - getStart()) + 1];
        for (int i = 0; i < points.length; i++) {
            points[i] = getStart() + i;
        }
        return points;
    }
}
