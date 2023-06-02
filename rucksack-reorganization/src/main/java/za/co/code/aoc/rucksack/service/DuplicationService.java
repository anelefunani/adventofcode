package za.co.code.aoc.rucksack.service;

import za.co.code.aoc.rucksack.domain.Duplicates;
import za.co.code.aoc.rucksack.domain.Rucksacks;

public interface DuplicationService {
    Duplicates getDuplicates(Rucksacks rucksacks);
}
