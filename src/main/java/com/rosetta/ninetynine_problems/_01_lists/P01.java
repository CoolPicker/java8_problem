package com.rosetta.ninetynine_problems._01_lists;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * (*) Find the last element of a list.
 * <p>
 * Check P01Test class for test cases related to this problem.
 */
public class P01 {

    /*
    You could solve this using many different approaches.
    If you work with List interface then you can find the last element using List size as shown below.
    获取集合长度,得到最后元素的角标,直接获取
     */
    public static <T> T last(List<T> elements) {
        int numberOfElements = elements.size();
        return elements.get(numberOfElements - 1);
    }

    /*
    Another way to solve this is by using LinkedList instead of a List.
    LinkedList provides a builtin getLast method.
    针对链表,可直接获取最后一项Entry
     */
    public static <T> T last(LinkedList<T> elements) {
        return elements.getLast();
    }


    /*
    A functional approach could be to use recursion.  We call the function recursively with a sub list which ignores the 0th element.
    When we reach the end i.e. size of the list is 1 then we return that element.
    采用递归向右偏移一位截取子表的方式,直到长度为一,即为最后一个元素
    */
    public static <T> T lastRecursive(List<T> elements) {
        if (elements == null || elements.isEmpty()) {
            throw new NoSuchElementException();
        }
        if (elements.size() == 1) {
            return elements.get(0);
        }
        return lastRecursive(elements.subList(1, elements.size()));
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,3,4,9,88,23);
        LinkedList<String> listStr = new LinkedList<>(Arrays.asList("232","2342","4534"));
        System.out.println(list.get(list.size()-1));
        System.out.println(listStr.getLast());

        
    }


}
