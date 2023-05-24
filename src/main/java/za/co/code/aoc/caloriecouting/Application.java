package za.co.code.aoc.caloriecouting;

import za.co.code.aoc.caloriecouting.controllers.CaloriesController;
import za.co.code.aoc.caloriecouting.dao.impl.CaloriesDaoImpl;
import za.co.code.aoc.caloriecouting.services.impl.CaloriesServiceImpl;

public class Application {

    public static void main(String[] args) {
        System.out.println("Most calories: " + getController().mostCalories());
        System.out.println("Top three calories: " + getController().topThreeCalories());
    }

    private static CaloriesController getController() {
        return new CaloriesController(
                new CaloriesServiceImpl(
                        new CaloriesDaoImpl(
                                "src/main/resources/input.data")));
    }
}
