package za.co.code.aoc.rucksack;

import za.co.code.aoc.rucksack.controller.RucksackController;
import za.co.code.aoc.rucksack.dao.impl.RucksackDaoImpl;
import za.co.code.aoc.rucksack.service.impl.DuplicationServiceDay2;
import za.co.code.aoc.rucksack.service.impl.DuplicationServiceImpl;
import za.co.code.aoc.rucksack.service.impl.RucksackServiceImpl;

public class Application {

    public static void main(String[] args) {
        RucksackController rucksackController = new RucksackController(new RucksackServiceImpl(new RucksackDaoImpl("rucksack-reorganization/src/main/resources/input.data"), new DuplicationServiceImpl()));
        int prioritiesSum = rucksackController.getPrioritiesSum();
        System.out.println("Priorities sum day 1: " + prioritiesSum);

        rucksackController = new RucksackController(new RucksackServiceImpl(new RucksackDaoImpl("rucksack-reorganization/src/main/resources/input.data"), new DuplicationServiceDay2()));
        prioritiesSum = rucksackController.getPrioritiesSum();
        System.out.println("Priorities sum day 2: " + prioritiesSum);
    }
}
