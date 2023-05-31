package za.co.code.aoc.rockpaperscissors.dao.impl;

import za.co.code.aoc.rockpaperscissors.adaptor.Adaptor;
import za.co.code.aoc.rockpaperscissors.adaptor.impl.RawToShapesDay1;
import za.co.code.aoc.rockpaperscissors.dao.RockPaperScissorsDao;
import za.co.code.aoc.rockpaperscissors.domain.ImmutableShapes;
import za.co.code.aoc.rockpaperscissors.domain.Shapes;
import za.co.code.aoc.rockpaperscissors.domain.enums.Shape;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RockPaperScissorsDaoUsingFile implements RockPaperScissorsDao {

    private final String fileLocation;

    private final Adaptor<String, Map<Shape, Shape>> rawToShapesAdaptor;

    public RockPaperScissorsDaoUsingFile(String fileLocation) {
        this.fileLocation = fileLocation;
        this.rawToShapesAdaptor = new RawToShapesDay1();
    }

    public RockPaperScissorsDaoUsingFile(String fileLocation, Adaptor<String, Map<Shape, Shape>> rawToShapesAdaptor) {
        this.fileLocation = fileLocation;
        this.rawToShapesAdaptor = rawToShapesAdaptor;
    }

    @Override
    public Shapes getRockPaperScissors() {
        try {
            List<String> contents = Files.readAllLines(Paths.get(fileLocation));
            // Remove line terminators
            contents = contents.stream()
                    .map(String::trim)
                    .map(c -> c.replace("\n", ""))
                    .map(c -> c.replace("\r", ""))
                    .collect(Collectors.toList());
            return ImmutableShapes.of(contents.stream().map(rawToShapesAdaptor::adapt).collect(Collectors.toList()));
        } catch (IOException e) {
            throw new IllegalStateException("Something went wrong, we could not read file: " + fileLocation);
        }
    }
}
