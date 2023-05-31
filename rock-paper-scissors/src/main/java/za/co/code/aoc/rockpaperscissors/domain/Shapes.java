package za.co.code.aoc.rockpaperscissors.domain;

import org.immutables.value.Value;
import za.co.code.aoc.rockpaperscissors.domain.enums.Shape;

import java.util.List;
import java.util.Map;

@Value.Immutable
public abstract class Shapes extends Wrapper<List<Map<Shape, Shape>>> {
}
