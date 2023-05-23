package za.co.code.aoc.caloriecouting.controllers;

import za.co.code.aoc.caloriecouting.services.CaloriesService;

public class CaloriesController {

    private final CaloriesService caloriesService;

    public CaloriesController(CaloriesService caloriesService) {
        this.caloriesService = caloriesService;
    }

    public int mostCalories() {
        return caloriesService.getMostCalories().getValue();
    }
}
