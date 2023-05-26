package za.co.code.aoc.caloriecounting.services;

import za.co.code.aoc.caloriecounting.domain.value.MostCalories;
import za.co.code.aoc.caloriecounting.domain.value.TopMostCalories;

public interface CaloriesService {

    MostCalories getMostCalories();

    TopMostCalories getTopMostCalories();
}
