package za.co.code.aoc.supplystacks.utitls;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    private Utils() {}

    public static List<String> convertToList(String a) {
        return Arrays.stream(a.replace("\r", "")
                .split("\n"))
                .collect(Collectors.toList());
    }
}
