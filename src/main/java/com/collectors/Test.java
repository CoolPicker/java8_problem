package com.collectors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

    public static void main(String[] args) {

//        Map<String,String> map = new HashMap<>();
//        String put = map.put("tom", "jerry");
//        String put1 = map.put("black", "white");
//        String batman = map.put("batman", "spider-man");
//        String put2 = map.put("black", "red");
//        // put new value return null
//        System.out.println(put);
//        System.out.println(put1);
//        System.out.println(batman);
//        // update value return oldValue
//        System.out.println(put2);
        List<String> list = new ArrayList<>();
        list.add("Peter");
        list.add("Jack");
        list.add("Joy");
        list.add("John");
        list.add("Tom");
        list.add("Jerry");
        list.add("Liz");
        for (Iterator<String> it = list.iterator();it.hasNext();) {
            String next = it.next();
            if (next.equals("Tom")) {
                // 操作Iterator，使用迭代器自带的remove方法
                it.remove();
                // 使用集合内部类Itr的进行迭代，调用删除方法将造成expectedModCount和modCount两变量不一致，
                // 删除后再行迭代将报错ConcurrentModificationException
//                list.remove(next);
            }
            System.out.println(next);
        }
        System.out.println("---------------------");
        for (String each : list) {
            System.out.println(each);
        }

    }
}
