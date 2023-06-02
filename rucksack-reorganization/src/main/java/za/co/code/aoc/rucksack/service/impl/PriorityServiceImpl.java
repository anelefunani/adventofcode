package za.co.code.aoc.rucksack.service.impl;

import za.co.code.aoc.rucksack.service.PriorityService;

import java.util.HashMap;
import java.util.Map;

public class PriorityServiceImpl implements PriorityService {

    private static PriorityService INSTANCE = null;

    static {
        dictionary = new HashMap<>();
    }

    private PriorityServiceImpl() {
        dictionary.put('a', 1);
        dictionary.put('b', 2);
        dictionary.put('c', 3);
        dictionary.put('d', 4);
        dictionary.put('e', 5);
        dictionary.put('f', 6);
        dictionary.put('g', 7);
        dictionary.put('h', 8);
        dictionary.put('i', 9);
        dictionary.put('j', 10);
        dictionary.put('k', 11);
        dictionary.put('l', 12);
        dictionary.put('m', 13);
        dictionary.put('n', 14);
        dictionary.put('o', 15);
        dictionary.put('p', 16);
        dictionary.put('q', 17);
        dictionary.put('r', 18);
        dictionary.put('s', 19);
        dictionary.put('t', 20);
        dictionary.put('u', 21);
        dictionary.put('v', 22);
        dictionary.put('w', 23);
        dictionary.put('x', 24);
        dictionary.put('y', 25);
        dictionary.put('z', 26);
        dictionary.put('A', 27);
        dictionary.put('B', 28);
        dictionary.put('C', 29);
        dictionary.put('D', 30);
        dictionary.put('E', 31);
        dictionary.put('F', 32);
        dictionary.put('G', 33);
        dictionary.put('H', 34);
        dictionary.put('I', 35);
        dictionary.put('J', 36);
        dictionary.put('K', 37);
        dictionary.put('L', 38);
        dictionary.put('M', 39);
        dictionary.put('N', 40);
        dictionary.put('O', 41);
        dictionary.put('P', 42);
        dictionary.put('Q', 43);
        dictionary.put('R', 44);
        dictionary.put('S', 45);
        dictionary.put('T', 46);
        dictionary.put('U', 47);
        dictionary.put('V', 48);
        dictionary.put('W', 49);
        dictionary.put('X', 50);
        dictionary.put('Y', 51);
        dictionary.put('Z', 52);
    }

    private static final Map<Character, Integer> dictionary;

    public static PriorityService getInstance() {
        if (INSTANCE == null) {
            return new PriorityServiceImpl();
        }
        return INSTANCE;
    }

    @Override
    public int getPriority(char c) {
        return dictionary.get(c);
    }
}
