package com.rosetta.ninetynine_problems._01_lists;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

/**
 * <b> (*) Run-length encoding of a list.</b>
 */
public class P10 {

    /*
    扫描连续不同字符到Entry,保存字符与个数
     */
    public static <T> List<SimpleEntry<Integer, T>> encode(List<T> list) {
        return P09.pack(list).stream().map(l -> new SimpleEntry<>(l.size(), l.get(0))).collect(toList());
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e");
        List<SimpleEntry<Integer, String>> collect = pack(list).stream().map(l -> new SimpleEntry<>(l.size(), l.get(0))).collect(toList());
        System.out.println(collect);
    }

    static <T> List<List<T>> pack(List<T> list) {
        List<List<T>> packRes = new ArrayList<>();
        List<T> items = new ArrayList<>();
        T lastElement = null;
        for (T t :
                list) {
            if (!Objects.equals(lastElement, t)) {
                items = new ArrayList<>();
                packRes.add(items);
            }
            items.add(t);
            lastElement = t;
        }
        return packRes;
    }
}
