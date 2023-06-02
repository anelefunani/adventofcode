package za.co.code.aoc.rucksack.controller;

import za.co.code.aoc.rucksack.service.RucksackService;

public class RucksackController {

    private RucksackService rucksackService;


    public RucksackController(RucksackService rucksackService) {
        this.rucksackService = rucksackService;
    }

    public int getPrioritiesSum() {
        return rucksackService.reorganise().getValue();
    }
}
