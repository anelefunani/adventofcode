package za.co.code.aoc.rucksack.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.aoc.rucksack.dao.RucksackDao;
import za.co.code.aoc.rucksack.dao.impl.RucksackDaoImpl;
import za.co.code.aoc.rucksack.domain.*;

import java.util.Arrays;
import java.util.Map;

class DuplicationServiceDay2Test {

    private RucksackDao rucksackDao;
    private DuplicationServiceDay2 duplicationService;

    @BeforeEach
    void setUp() {
        rucksackDao = new RucksackDaoImpl("src/test/resources/input.data");
        duplicationService = new DuplicationServiceDay2();
    }

    @Test
    void getDuplicates() {
        Rucksacks rucksacks = rucksackDao.getRucksacks();
        duplicationService.getDuplicates(rucksacks);
        Map<Badge, Integer> groups = duplicationService.getGroups();
        Assertions.assertNotNull(groups);
        System.out.println("Group size: " + groups.size());
        groups.forEach((k, v) -> System.out.println(k + ", " + v));
    }

    @Test
    void given_a_return_a() {
        String rucksackItems = "a";
        ImmutableRucksack rucksack = ImmutableRucksack.of(rucksackItems);
        duplicationService.getDuplicates(ImmutableRucksacks.of(Arrays.asList(rucksack)));
        Assertions.assertTrue(duplicationService.getGroups().containsKey(ImmutableBadge.of('a')));
        Assertions.assertEquals( 1, duplicationService.getGroups().get(ImmutableBadge.of('a')));
    }

    @Test
    void permutations() {
        duplicationService.getDuplicates(ImmutableRucksacks.of(Arrays.asList(
                ImmutableRucksack.of("abc"),
                ImmutableRucksack.of("bbc"),
                ImmutableRucksack.of("ccc"))));
        System.out.println(duplicationService.getGroups());
        Assertions.assertEquals(3, duplicationService.getGroups().get(ImmutableBadge.of('c')));
    }
}