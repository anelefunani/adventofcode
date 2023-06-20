package za.co.code.aoc.supplystacks.service.impl;

import za.co.code.aoc.supplystacks.dao.SupplyStacksSummaryDao;
import za.co.code.aoc.supplystacks.domain.*;
import za.co.code.aoc.supplystacks.service.SupplyStacksService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class SupplyStacksServiceComplex extends SupplyStacksServiceSimple implements SupplyStacksService {

    public SupplyStacksServiceComplex(SupplyStacksSummaryDao supplyStacksSummaryDao) {
        super(supplyStacksSummaryDao);
    }

    @Override
    public TopCrates getTopCrates() {

        doCraneInstructions();

        StringBuilder topCrates = new StringBuilder();
        getStacks().getValue().forEach(s -> topCrates.append(s.getCrates().getFirst().getCrateLabel().getValue()));

        return ImmutableTopCrates.of(topCrates.toString());
    }

    @Override
    protected void doCraneInstructions() {
        IntStream.range(0, getInstructions().getInstructions().size())
                .forEach(idx -> doCraneInstructions(getStacks(), getInstructions().getInstructions().get(idx)));
    }

    @Override
    protected void doCraneInstructions(Stacks stacks, Instruction instruction) {
        Stack from = stacks.getValue().get(instruction.getFrom().getValue());
        Stack to = stacks.getValue().get(instruction.getTo().getValue());

        List<Crate> cratesToBeMoved = new ArrayList<>();
        IntStream.range(0, instruction.getNumberOfMoves().getValue())
                        .forEach(x -> cratesToBeMoved.add(from.getCrates().pop()));

        Collections.reverse(cratesToBeMoved);

        cratesToBeMoved.forEach(x -> to.getCrates().addFirst(x));
    }
}
