package com.concurrent;

import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Description TODO
 * @Author nya
 * @Date 2020/7/2 下午1:27
 **/
public class ListOperate {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("/home/lab/1.txt"));
//        BufferedReader br2 = new BufferedReader(new FileReader("/home/lab/1.txt"));
//        BufferedWriter bw = new BufferedWriter(new FileWriter("/home/lab/1.txt"));
//        bw.write("aa");
//        bw.flush();
//        br.lines().forEach(System.out::println);
//        bw.write("bb");
//        bw.flush();
//        br2.lines().forEach(System.out::println);

        for (int i = 0; i < 100; i++) {
            int nextInt = ThreadLocalRandom.current().nextInt(80,90);
            System.out.println(nextInt);
        }


//        List<Integer> integers = new LinkedList<>(Arrays.asList(0, 1, 2, 4, 3, 4, 6, 5, 6, 7, 8, 9));
//        Iterator<Integer> iterator = integers.iterator();
//        while (iterator.hasNext()) {
//            Integer item = iterator.next();
//            if (item % 2 == 0) {
//                iterator.remove();
//            }
//        }
//        System.out.println(integers);
        // 删除个位数集合中所有的偶数
//        List<Integer> list = new ArrayList<>(Arrays.asList(0,1,2,4,3,4,6,5,6,7,8,9));
//        ArrayList<Integer> firstList = new ArrayList<>(list);
//        ArrayList<Integer> tempList = new ArrayList<>(list);
//        ArrayList<Integer> lambdaList = new ArrayList<>(list);
//
//        // 1. 遍历长度指定 报错 java.lang.IndexOutOfBoundsException
//        int size = firstList.size();
//        for (int i = 0 ; i < size ; i++) {
//            Integer item = firstList.get(i);
//            if (item % 2 == 0) {
//                firstList.remove(item);
//            }
//        }
//        System.out.println(firstList);
//
//        // 2. 不报错 但只适合删除某个指定元素, 多个元素时会出现异常,以为集合变化,循环索引递增
//        for (int i = 0; i < list.size(); i++) {
//            Integer item = list.get(i);
//            if (item % 2 == 0) {
//                list.remove(item);
//            }
//        }
//        System.out.println(list);
//
//        // 3. 报错 java.util.ConcurrentModificationException
//        for (int item : tempList) {
//            if (item % 2 == 0) {
//                tempList.remove(item);
//            }
//        }
//        System.out.println(tempList);
//
//        // 4-1. 使用迭代器循环 JDK8之前推荐:
//        Iterator<Integer> iterator = tempList.iterator();
//        while (iterator.hasNext()) {
//            Integer item = iterator.next();
//            if (item % 2 == 0) {
//                // 使用集合的remove()报错 java.util.ConcurrentModificationException
////                tempList.remove(item);
//                // 使用 iterator 的remove()
//                iterator.remove();
//            }
//        }
//        System.out.println(tempList);
//
//        // 4-2. 推荐: jdk8,使用lambda表达式,原理即迭代器操作循环
//        lambdaList.removeIf(item -> {
//            System.out.println(item);
//            return item % 2 == 0;
//        });
//        System.out.println(lambdaList);
    }

}
