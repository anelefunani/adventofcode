package za.co.code.aoc.caloriecouting.dao.impl;

import za.co.code.aoc.caloriecouting.dao.CaloriesDao;
import za.co.code.aoc.caloriecouting.domain.values.Elves;
import za.co.code.aoc.caloriecouting.adapters.Adapter;
import za.co.code.aoc.caloriecouting.adapters.impl.RawToElvesAdapter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CaloriesDaoImpl implements CaloriesDao {

    private String fileLocation;

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
