package za.co.code.aoc.supplystacks.controller;

import za.co.code.aoc.supplystacks.service.SupplyStacksService;

public class SupplyStacksController {

    private final SupplyStacksService supplyStacksService;

    public SupplyStacksController(SupplyStacksService supplyStacksService) {
        this.supplyStacksService = supplyStacksService;
    }

    public String getTopCrates() {
        return supplyStacksService.getTopCrates().getValue();
    }
}
