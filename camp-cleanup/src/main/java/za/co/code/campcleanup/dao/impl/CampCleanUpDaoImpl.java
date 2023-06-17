package za.co.code.campcleanup.dao.impl;

import za.co.code.campcleanup.dao.CampCleanUpDao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CampCleanUpDaoImpl implements CampCleanUpDao {

    private final String fileLocation;

    public CampCleanUpDaoImpl(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    public byte[] getCampCleanUp() {
        try {
            return Files.readAllBytes(Paths.get(fileLocation));
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new IllegalStateException("Something went wrong, we could not read file at location: " + fileLocation);
        }
    }
}
