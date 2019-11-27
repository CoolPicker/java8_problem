package com.rosetta.ninetynine_problems._01_lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * <b>(**) Flatten a nested list structure</b>
 * <p>
 * Transform a list, possibly holding lists as elements into a 'flat' list by replacing each list with its elements (recursively).
 * </p>
 */
public class P07 {

    /*
    采用递归的方式,整合嵌套的集合,并强转为指定格式
     */
    public static <T> List<T> flatten(List<?> list, Class<T> elementType) {
        List<T> flatten = new ArrayList<>();
        list.forEach(e -> {
            if (e instanceof List) {
                flatten.addAll(flatten((List<?>) e, elementType));
            } else {
                flatten.add((T) e);
            }
        });
        return flatten;
    }

    /*
    借助流处理,强转嵌套的集合为指定类型元素集合,同上主要思路是递归
     */
    public static <T> List<T> flatten_stream(List<?> list, Class<T> elementType) {
        return list
                .stream()
                .flatMap(e -> e instanceof List ? flatten_stream(((List<?>) e), elementType).stream() : Stream.of(e))
                .map(e -> (T) e)
                .collect(toList());
    }

    public static void main(String[] args) {
        List<Object> objects = asList("a", asList("b", asList("c", "d")), "e");
        System.out.println(objects);
        System.out.println(flatten(objects,String.class));
    }
}
