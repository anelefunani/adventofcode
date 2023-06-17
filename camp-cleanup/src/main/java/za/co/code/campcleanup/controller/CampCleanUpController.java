package za.co.code.campcleanup.controller;

import za.co.code.campcleanup.service.CampCleanUpService;

public class CampCleanUpController {

    private final CampCleanUpService campCleanUpService;

    public CampCleanUpController(CampCleanUpService campCleanUpService) {
        this.campCleanUpService = campCleanUpService;
    }

    public Integer getNumberOfFullyContainedPairs() {
        return campCleanUpService.cleanup().getValue();
    }
}
