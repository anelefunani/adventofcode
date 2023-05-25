package za.co.code.aoc.caloriecounting;

import za.co.code.aoc.caloriecounting.controllers.CaloriesController;
import za.co.code.aoc.caloriecounting.dao.impl.CaloriesDaoImpl;
import za.co.code.aoc.caloriecounting.services.impl.CaloriesServiceImpl;

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
