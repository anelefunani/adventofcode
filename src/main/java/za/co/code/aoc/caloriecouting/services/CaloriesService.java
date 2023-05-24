package za.co.code.aoc.caloriecouting.services;

import za.co.code.aoc.caloriecouting.domain.value.MostCalories;
import za.co.code.aoc.caloriecouting.domain.value.TopMostCalories;

public interface CaloriesService {

    MostCalories getMostCalories();

    TopMostCalories getTopMostCalories();
}
