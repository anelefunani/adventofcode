package za.co.code.aoc.caloriecounting.dao.impl;

import za.co.code.aoc.caloriecounting.adapters.Adapter;
import za.co.code.aoc.caloriecounting.adapters.impl.RawToElvesAdapter;
import za.co.code.aoc.caloriecounting.dao.CaloriesDao;
import za.co.code.aoc.caloriecounting.domain.values.Elves;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CaloriesDaoImpl implements CaloriesDao {

    private final String fileLocation;

    private static final Adapter<Elves, byte[]> rawToCaloriesAdapter = new RawToElvesAdapter();

    public CaloriesDaoImpl(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    public Elves getElves() {
        try {
            return rawToCaloriesAdapter.adapt(Files.readAllBytes(Paths.get(fileLocation)));
        } catch (IOException e) {
            throw new IllegalStateException("Could not read file at: " + fileLocation);
        }
    }
}
