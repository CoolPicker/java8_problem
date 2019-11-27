package com.rosetta.ninetynine_problems._01_lists;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <b><(**) Drop every N'th element from a list/b>
 */
public class P16 {

    /*
    剔除指定大小整数倍长度的所有元素
     */
    public static <T> List<T> dropEveryNth(List<T> list, int n) {
        if (n == 0) {
            return list;
        }
        return IntStream.range(0, list.size())
                .mapToObj(i -> new SimpleEntry<>(list.get(i), i))
                .filter(entry -> (entry.getValue() + 1) % n != 0)
                .map(SimpleEntry::getKey)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> resList = dropEveryNth(intList, 3);
        System.out.println(resList);
    }
}
