package com.rosetta.ninetynine_problems._01_lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Find out whether a list is a palindrome.
 * 判定集合是否为回文集合,即正逆序相同
 * 使用Objects工具类用以比较两个集合及其中元素是否一一匹配
 */
public class P06 {

    public static <T> boolean isPalindrome(List<T> list) {
        List<T> original = new ArrayList<>(list);
        P05.reverse(list);
        return Objects.equals(list, original);
    }

    public static <T> boolean isPalindrome_IntStream(List<T> list) {
        List<T> reversed = P05.reverse_IntStream(list);
        return Objects.equals(list, reversed);
    }

}
