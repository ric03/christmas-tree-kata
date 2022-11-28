package com.github.ric03.christmastreekata;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChristmasTreeKata {

    private static final String STUMP = "|";
    public static final String LEAF = "X";

    public List<String> drawTree(int size) {
        if (size <= 0) {
            return List.of(STUMP);
        }

        List<String> tree = IntStream
            .range(0, size)
            .mapToObj(idx -> {
                var indentation = " ".repeat(size - idx - 1);
                var leaves = LEAF.repeat(idx * 2 + 1);
                return indentation.concat(leaves);
            })
            .collect(Collectors.toList());

        var indentation = " ".repeat(size - 1);
        var stump = indentation.concat(STUMP);

        tree.add(stump);
        return tree;
    }
}
