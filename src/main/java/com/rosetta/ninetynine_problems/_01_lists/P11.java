package com.rosetta.ninetynine_problems._01_lists;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * <b>(*) Modified run-length encoding</b>
 * <pre>
 *      encode_modified(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"))
 * </pre>
 */
public class P11 {

    /*
    包装连续不同的元素,长度唯一保存元素,否则保存个数与值
     */
    public static <T> List<Object> encode_modified(List<T> list) {
        return P09.pack(list).stream().map(l -> {
            if (l.size() == 1) {
                return l.get(0);
            }
            return new SimpleEntry<>(l.size(), l.get(0));
        }).collect(toList());
    }

    public static void main(String[] args) {
        List<Object> list = encode_modified(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"));
        System.out.println(list);
    }

}
