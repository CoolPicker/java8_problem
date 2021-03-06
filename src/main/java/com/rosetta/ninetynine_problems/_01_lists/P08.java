package com.rosetta.ninetynine_problems._01_lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * <b>(**) Eliminate consecutive duplicates of list elements</b>
 * <p>If a list contains repeated elements they should be replaced with a single copy of the element.
 * The order of the elements should not be changed.</p>
 * <p>
 * <pre>
 *     compress(Arrays.asList(a,a,a,a,b,c,c,a,a,d,e,e,e,e))
 *     [a,b,c,d,e]
 * </pre>
 */
public class P08 {

    /*
    去除集合中元素连续重复项,并保留元素顺序不变
     */
    public static <T> List<T> compress(List<T> list) {
        Objects.requireNonNull(list, "Please make sure list is not null");
        List<T> result = new ArrayList<>();
        T lastElement = null;
        for (T e : list) {
            if (!Objects.equals(lastElement, e)) {
                result.add(e);
            }
            lastElement = e;
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> resList = compress(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"));
        System.out.println(resList);
    }

}
