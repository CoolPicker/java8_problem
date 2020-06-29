package com.rosetta.ninetynine_problems._01_lists;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

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

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("2","4","8"));
        List<String> listTemp = new LinkedList<>(Arrays.asList("2","4","8"));
        System.out.println(Objects.equals(list,listTemp));
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        System.out.println(listTemp);
        System.out.println(reverse(listTemp));
        System.out.println(IntStream.iterate(list.size() -1 ,el -> el -1).limit(list.size()).mapToObj(list::get).collect(toList()));
    }


    private static <T> List<T> reverse(List<T> list){
        LinkedList<T> before = new LinkedList(list);
        LinkedList<T> res = new LinkedList();
        for (T t :
                before) {
            res.addFirst(t);
        }
        return res;
    }

}
