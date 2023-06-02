package za.co.code.aoc.rucksack.dao.impl;

import za.co.code.aoc.rucksack.adaptor.Adaptor;
import za.co.code.aoc.rucksack.adaptor.impl.RawToRucksacks;
import za.co.code.aoc.rucksack.dao.RucksackDao;
import za.co.code.aoc.rucksack.domain.Rucksacks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class RucksackDaoImpl implements RucksackDao {

    private Adaptor<Rucksacks, List<String>> rucksacksAdaptor;

    private String fileLocation;

    public RucksackDaoImpl(String fileLocation) {
        this.fileLocation = fileLocation;
        rucksacksAdaptor = new RawToRucksacks();
    }

    @Override
    public Rucksacks getRucksacks() {
        try {
            return rucksacksAdaptor.adapt(Files.readAllLines(Paths.get(fileLocation)));
        } catch (IOException e) {
            throw new IllegalStateException("Something went wrong, we could read the file in location: " + fileLocation);
        }
    }
}
