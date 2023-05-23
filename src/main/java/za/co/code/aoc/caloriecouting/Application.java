package za.co.code.aoc.caloriecouting;

import za.co.code.aoc.caloriecouting.controllers.CaloriesController;
import za.co.code.aoc.caloriecouting.dao.impl.CaloriesDaoImpl;
import za.co.code.aoc.caloriecouting.services.impl.CaloriesServiceImpl;

public class Application {

    public static void main(String[] args) {
        CaloriesController caloriesController = new CaloriesController(
                new CaloriesServiceImpl(
                        new CaloriesDaoImpl(
                                "src/main/resources/input.data")));
        int mostCalories = caloriesController.mostCalories();
        System.out.println("Most calories: " + mostCalories);
    }
}
