package za.co.code.campcleanup;

import za.co.code.campcleanup.controller.CampCleanUpController;
import za.co.code.campcleanup.dao.CampCleanUpDao;
import za.co.code.campcleanup.dao.impl.CampCleanUpDaoImpl;
import za.co.code.campcleanup.service.CampCleanUpService;
import za.co.code.campcleanup.service.ContainsCounterService;
import za.co.code.campcleanup.service.impl.CampCleanUpServiceImpl;
import za.co.code.campcleanup.service.impl.FullyContainsServiceImpl;
import za.co.code.campcleanup.service.impl.PartiallyContainsServiceImpl;

public class Application {

    public static void main(String[] args) {
        count("fully", new FullyContainsServiceImpl());
        count("partially", new PartiallyContainsServiceImpl());
    }

    private static void count(String type, ContainsCounterService containsCounterService) {
        final String location = "camp-cleanup/src/main/resources/input.data";
        final CampCleanUpDao campCleanUpDao = new CampCleanUpDaoImpl(location);
        final CampCleanUpService campCleanUpService = new CampCleanUpServiceImpl(campCleanUpDao, containsCounterService);
        final CampCleanUpController campCleanUpController = new CampCleanUpController(campCleanUpService);

        System.out.println("Number of " + type + " contained pairs = " + campCleanUpController.getNumberOfFullyContainedPairs());
    }
}
