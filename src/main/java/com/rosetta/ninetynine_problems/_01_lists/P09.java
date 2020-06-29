package com.rosetta.ninetynine_problems._01_lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * <b>(**) Pack consecutive duplicates of list elements into sublists</b>
 * <p>If a list contains repeated elements they should be placed in separate sublists.</p>
 *
 * <pre>
 *     pack(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"))
 *     [["a","a","a","a"],["b"],["c","c"],["a","a"],["d"],["e","e","e","e"]]
 * </pre>
 */
public class P09 {

    /*
    Simple approach using for-each loop
    连续重复元素放入新集合并最终打包至结果集合
     */
    public static <T> List<List<T>> pack(List<T> list) {
        T lastElement = null;
        List<List<T>> packedList = new ArrayList<>();
        List<T> elements = new ArrayList<>();
        for (T el : list) {
            if (!Objects.equals(lastElement, el)) {
                elements = new ArrayList<>();
                packedList.add(elements);
            }
            elements.add(el);
            lastElement = el;
        }
        return packedList;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e");
        List<List<String>> pack = pack(list);
        System.out.println(pack);
    }


}
