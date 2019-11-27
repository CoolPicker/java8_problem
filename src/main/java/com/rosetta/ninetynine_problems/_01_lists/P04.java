package com.rosetta.ninetynine_problems._01_lists;

import java.util.List;

/**
 * Find the number of elements of a list
 */
public class P04 {

    /*
    直接获取集合长度
     */
    public static <T> int length(List<T> list) {
        return list.size();
    }

    /*
    采用流处理方式,直接获取计数大小
     */
    public static <T> long lengthStream(List<T> list) {
        return list.stream().count();
    }

    /*
    转换集合元素为1,求和即可
     */
    public static <T> long lengthStream1(List<T> list) {
        return list.stream().mapToInt(x -> 1).sum();
    }

    /*
    递归右移分割集合的同时初始值为0的变量累加,集合为空时变量值即为长度值
     */
    public static <T> int lengthRecursive(List<T> list) {
        return _lengthRecursive(list, 0);
    }

    private static <T> int _lengthRecursive(List<T> list, int i) {
        if (list.isEmpty()) {
            return i;
        }
        return _lengthRecursive(list.subList(1, list.size()), ++i);
    }
}
