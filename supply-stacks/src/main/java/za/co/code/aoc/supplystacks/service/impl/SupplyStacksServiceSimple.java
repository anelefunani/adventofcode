package za.co.code.aoc.supplystacks.service.impl;

import za.co.code.aoc.supplystacks.dao.SupplyStacksSummaryDao;
import za.co.code.aoc.supplystacks.domain.*;
import za.co.code.aoc.supplystacks.service.SupplyStacksService;

import java.util.stream.IntStream;

public class SupplyStacksServiceSimple implements SupplyStacksService {

    protected final Stacks stacks;

    protected final Instructions instructions;

    public SupplyStacksServiceSimple(SupplyStacksSummaryDao supplyStacksSummaryDao) {
        StackInfo supplyStacksSummary = supplyStacksSummaryDao.getSupplyStacksSummary();
        this.stacks = supplyStacksSummary.getStacks();
        this.instructions = supplyStacksSummary.getInstructions();
    }

    @Override
    public TopCrates getTopCrates() {

        doCraneInstructions();

        StringBuilder topCrates = new StringBuilder();
        getStacks().getValue().forEach(s -> topCrates.append(s.getCrates().pop().getCrateLabel().getValue()));

        return ImmutableTopCrates.of(topCrates.toString());
    }

    protected void doCraneInstructions() {
        IntStream.range(0, getInstructions().getInstructions().size())
                .forEach(idx -> doCraneInstructions(getStacks(), getInstructions().getInstructions().get(idx)));
    }

    protected void doCraneInstructions(Stacks stacks, Instruction instruction) {
        Integer numberOfMoves = instruction.getNumberOfMoves().getValue();
        Stack from = stacks.getValue().get(instruction.getFrom().getValue());
        Stack to = stacks.getValue().get(instruction.getTo().getValue());

        IntStream.range(0, numberOfMoves)
                        .forEach(idx -> to.getCrates().addFirst(from.getCrates().pop()));
    }

    protected Stacks getStacks() {
        return this.stacks;
    }

    protected Instructions getInstructions() {
        return this.instructions;
    }
}
