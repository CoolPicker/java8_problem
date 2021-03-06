package com.rosetta.ninetynine_problems._01_lists;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * <b>(**) Decode a run-length encoded list.</b>
 * <pre>
 *     decode(Arrays.asList((4, "a"), "b", (2, "c"), (2, "a"), "d", (4, "e")))
 * </pre>
 */
public class P12 {

    /*
    打包后的Entry集合转为元素集合
     */
    public static <T> List<T> decode(List<Object> encoded) {
        return encoded.stream().flatMap(e -> {
            if (e instanceof SimpleEntry) {
                SimpleEntry<Integer, T> entry = (SimpleEntry<Integer, T>) e;
                return Collections.nCopies(entry.getKey(), entry.getValue()).stream();
            }
            return Stream.of((T) e);
        }).collect(toList());
    }

    public static void main(String[] args) {
        List<Object> decode = decode(Arrays.asList(
                new SimpleEntry<>(4, "a"),
                "b",
                new SimpleEntry<>(2, "c"),
                new SimpleEntry<>(2, "a"),
                "d",
                new SimpleEntry<>(4, "e")));
        System.out.println(decode);
    }
}
