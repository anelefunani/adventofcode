package za.co.code.aoc.supplystacks.dao.impl;

import za.co.code.aoc.supplystacks.dao.SupplyStacksSummaryDao;
import za.co.code.aoc.supplystacks.dao.SupplyStacksDao;
import za.co.code.aoc.supplystacks.domain.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SupplyStacksSummaryDaoImpl implements SupplyStacksSummaryDao {

    private static final Pattern NUMBERS_PATTERN = Pattern.compile("^\\d+$");

    private static final Pattern CRATES_PATTERN = Pattern.compile("[A-Z]");

    private final int indexOfStackIndexes;

    private final int indexOfInstructions;

    private final int  numberOfStacks;

    private final List<String> stacks;

    private final List<String> instructions;

    private final Integer[] stackIndexes;


    public SupplyStacksSummaryDaoImpl(SupplyStacksDao supplyStacksDao) {
        final List<String> supplyStacks = supplyStacksDao.getSupplyStacks();
        this.indexOfStackIndexes = getIndexOfStackIndexes(supplyStacks);
        this.stackIndexes = getStackIndexes(supplyStacks.get(getIndexOfStackIndexes()));
        this.indexOfInstructions = getIndexOfInstructions();
        this.numberOfStacks = getNumberOfStacks(supplyStacks, getIndexOfStackIndexes());
        this.stacks = supplyStacks.subList(0, getIndexOfStackIndexes());
        this.instructions = supplyStacks.subList(getIndexOfInstructions(), supplyStacks.size());
    }

    @Override
    public StackInfo getSupplyStacksSummary() {

        ImmutableStackInfo stackInfo = ImmutableStackInfo.builder()
                .numberOfStacks(ImmutableNumberOfStacks.of(getNumberOfStacks()))
                .stackIndexes(ImmutableStackIndexes.of(getStackIndexes()))
                .startOfInstructionsIndex(ImmutableStartOfInstructionsIndex.of(getIndexOfInstructions()))
                .startOfStacksIndex(ImmutableStartOfStacksIndex.of(getStartOfStacksIndex()))
                .instructions(buildInstructions())
                .build();

        return ImmutableStackInfo.copyOf(stackInfo)
                .withStacks(buildStacks(stackInfo.getStacks()));
    }

    private Stacks buildStacks(Stacks stacks) {
        for (int i = getStacks().size() - 1; i >= 0 ; i--) {
            String s1 = getStacks().get(i);
            Matcher matcher = CRATES_PATTERN.matcher(getStacks().get(i));
            int lastIndex = 0;
            while (matcher.find()) {
                String match = matcher.toMatchResult().group();
                int indexOfMatch = s1.indexOf(match, lastIndex);
                lastIndex = indexOfMatch + 1;
                int indexOfStack = indexOfMatch / 4;
                stacks.getValue().get(indexOfStack).getCrates().addFirst(ImmutableCrate.of(
                        ImmutableCrateLabel.of(match)
                ));
            }
        }

        return ImmutableStacks.builder()
                .addAllValue(stacks.getValue())
                .build();
    }


    private int getStartOfStacksIndex() {
        return getIndexOfStackIndexes() - 1;
    }

    private int getIndexOfStackIndexes(List<String> supplyStacksInfo) {
        for (int i = 0; i < supplyStacksInfo.size(); i++) {
            if (isDigitsOnly(supplyStacksInfo.get(i))) {
                return  i;
            }
        }
        return 0;
    }

    private int getIndexOfStackIndexes() {
        return this.indexOfStackIndexes;
    }

    private boolean isDigitsOnly(String s) {
        return NUMBERS_PATTERN.matcher(s.replaceAll("\\s+", "")).find();
    }


    private Integer[] getStackIndexes(String s) {
        return Arrays.stream(s.split(" "))
                .filter(x -> !x.isEmpty())
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

    private Integer[] getStackIndexes() {
        return this.stackIndexes;
    }

    private int getIndexOfInstructions() {
        return this.getIndexOfStackIndexes() + 2;
    }

    private int getNumberOfStacks(List<String> s, int i) {
        return Arrays.stream(s.get(i).split(" "))
                .filter(x -> !x.isEmpty())
                .toArray(String[]::new).length;
    }

    private int getNumberOfStacks() {
        return this.numberOfStacks;
    }

    private List<String> getStacks() {
        return this.stacks;
    }

    private List<String> getInstructions() {
        return this.instructions;
    }

    private Instructions buildInstructions() {
        return ImmutableInstructions.builder()
                .addAllInstructions(getInstructions().stream().map(x -> {
                    String[] s = Arrays.stream(x.split(" "))
                            .filter(xx -> !xx.isEmpty())
                            .toArray(String[]::new);

                    return ImmutableInstruction.builder()
                            .numberOfMoves(ImmutableNumberOfMoves.of(Integer.parseInt(s[1])))
                            .from(ImmutableFrom.of(Integer.parseInt(s[3]) - 1))
                            .to(ImmutableTo.of(Integer.parseInt(s[5]) - 1))
                            .build();
                }).collect(Collectors.toList()))
                .build();
    }
}
