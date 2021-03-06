package com.rosetta.ninetynine_problems._01_lists;


import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * (*) Duplicate the elements of a list
 * <pre>
 *          duplicate(Arrays.asList("a", "b", "c", "d"))
 * </pre>
 */
public class P14 {

    /*
    复制元素得到新的2n长度的集合
     */
    public static <T> List<T> duplicate(List<T> list) {
        return list.stream().flatMap(e -> Stream.of(e, e)).collect(toList());
    }
}
