package za.co.code.aoc.supplystacks.dao.impl;

import za.co.code.aoc.supplystacks.adapter.Adapter;
import za.co.code.aoc.supplystacks.adapter.impl.RawToList;
import za.co.code.aoc.supplystacks.dao.SupplyStacksDao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SupplyStacksDaoImpl implements SupplyStacksDao {

    private final String pathToFile;

    private final Adapter<byte[], List<String>> rawToListAdapter;

    public SupplyStacksDaoImpl(String pathToFile) {
        this.pathToFile = pathToFile;
        this.rawToListAdapter = new RawToList();
    }

    @Override
    public List<String> getSupplyStacks() {

        try {
            return rawToListAdapter.adapt(Files.readAllBytes(Paths.get(pathToFile)));
        } catch (IOException e) {
            throw new IllegalStateException("Something went wrong, we could not read file at: " + pathToFile);
        }
    }
}
