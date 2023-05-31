package za.co.code.aoc.rockpaperscissors.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.code.aoc.rockpaperscissors.domain.enums.Shape;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShapesMap {
    private Map<Shape, Shape> shapes;
}
