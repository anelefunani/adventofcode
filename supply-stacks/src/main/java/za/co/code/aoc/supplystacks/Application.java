package za.co.code.aoc.supplystacks;

import za.co.code.aoc.supplystacks.controller.SupplyStacksController;
import za.co.code.aoc.supplystacks.dao.impl.SupplyStacksSummaryDaoImpl;
import za.co.code.aoc.supplystacks.dao.impl.SupplyStacksDaoImpl;
import za.co.code.aoc.supplystacks.service.impl.SupplyStacksServiceComplex;
import za.co.code.aoc.supplystacks.service.impl.SupplyStacksServiceSimple;

public class Application {

    public static void main(String[] args) {

        SupplyStacksController supplyStacksController = new SupplyStacksController(
                new SupplyStacksServiceSimple(
                        new SupplyStacksSummaryDaoImpl(
                                new SupplyStacksDaoImpl(
                                        "supply-stacks/src/main/resources/input.data")
                        )
                )
        );

        String topCrates = supplyStacksController.getTopCrates();

        System.out.println("(Simple) Top creates = " + topCrates); // CNSZFDVLJ

        supplyStacksController = new SupplyStacksController(
                new SupplyStacksServiceComplex(
                        new SupplyStacksSummaryDaoImpl(
                                new SupplyStacksDaoImpl(
                                        "supply-stacks/src/main/resources/input.data")
                        )
                )
        );

        topCrates = supplyStacksController.getTopCrates();

        System.out.println("(Complex) Top crates = " + topCrates); // QNDWLMGNS
    }
}
