package com.rosetta.ninetynine_problems._01_lists;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

/**
 * Reverse a list
 */
public class P05 {

    /*
    借助集合的工具类,实现整个集合的逆序
     */
    public static <T> List<T> reverse(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("list can't be null");
        }
        Collections.reverse(list);
        return list;
    }

    /*
    指定新集合,迭代旧集合,逆序获取元素添加到新集合
     */
    public static <T> List<T> reverse_foreach(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("list can't be null");
        }
        List<T> reversed = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        return reversed;
    }


    /*
    借助流处理
     */
    public static <T> List<T> reverse_IntStream(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("list can't be null");
        }
        int size = list.size();
        return IntStream.iterate(size - 1, el -> el - 1).limit(size).mapToObj(list::get).collect(toList());
    }

    /*
    流处理对于双端队列的逆序新集合获取
     */
    public static <T> List<T> reverse_customStream(ArrayDeque<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("list can't be null");
        }
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(list.descendingIterator(), Spliterator.ORDERED), false).collect(toList());
    }

    /*
    遍历旧链表集合,新增首元素,实现逆序新链表集合的获取
     */
    public static <T> List<T> reverse(LinkedList<T> elements){
        LinkedList<T> reversed = new LinkedList<T>();
        for(T e: elements){
            reversed.addFirst(e);
        }
        return reversed;
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(2,3,5,6,9,10);
        List<Integer> resList = IntStream.iterate(intList.size() - 1, el -> el - 1).limit(intList.size()).mapToObj(intList::get).collect(toList());
        System.out.println(intList);
        System.out.println(resList);
    }
}

