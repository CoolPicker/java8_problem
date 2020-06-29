package com.rosetta.ninetynine_problems._01_lists;

import java.util.AbstractMap.SimpleEntry;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * <b>(**) Run-length encoding of a list (direct solution)</b>
 */
public class P13 {

    /*
    整合版,迭代连续重复元素集合,并整合至包含元素和重复元素个数的SimpleEntry(key-value映射实例)集合中
     */
    public static List<SimpleEntry<Integer, String>> encode_direct(List<String> list) {
        LinkedList<SimpleEntry<Integer, String>> result = new LinkedList<>();
        String lastElem = null;
        for (String elem : list) {
            if (Objects.equals(lastElem, elem)) {
                SimpleEntry<Integer, String> last = result.removeLast();
                result.add(new SimpleEntry<>(last.getKey() + 1, elem));
            } else {
                result.add(new SimpleEntry<>(1, elem));
                lastElem = elem;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(i);
    }

}
