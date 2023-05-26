package za.co.code.aoc.caloriecounting.controllers;

import za.co.code.aoc.caloriecounting.services.CaloriesService;

public class CaloriesController {

    private final CaloriesService caloriesService;

    public CaloriesController(CaloriesService caloriesService) {
        this.caloriesService = caloriesService;
    }

    public int mostCalories() {
        return caloriesService.getMostCalories().getValue();
    }

    public int topThreeCalories() {
        return caloriesService.getTopMostCalories().getValue();
    }
}
