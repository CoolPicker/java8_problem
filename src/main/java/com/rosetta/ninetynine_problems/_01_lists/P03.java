package com.rosetta.ninetynine_problems._01_lists;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Find the Kth element of a list.
 */
public class P03 {

    /*
    获取指定位置的元素,直接根据角标获取
     */
    public static <T> T kth(final List<T> list, final int k) {
        return list.get(k);
    }

    /*
    递归向右偏移一位,并随之偏移量减一,当偏移量减至0时,已达指定位置,直接获取首元素即可
     */
    public static <T> T kthRecursive(final LinkedList<T> list, final int k) {
        if (k == 0) {
            return list.getFirst();
        }
        return kthRecursive(new LinkedList<>(list.subList(1, list.size())), k - 1);
    }

    /*
    链表,采用流处理的方式,直接截取到指定位置(注意截取区间右闭,如需包含需+1),获取新集合的最后一项即可
     */
    public static <T> T kthStream(final List<T> list, final int k) {
        return list.stream().limit(k + 1).collect(Collectors.toCollection(LinkedList::new)).getLast();
    }

}
