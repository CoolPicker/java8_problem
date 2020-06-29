package com.rosetta.test;

import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @Author nya
 * @Date 2020/3/10 上午10:51
 **/
public class BubbleSortTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 5, 2, 8);

//        for (int i = 0 ; i < list.size() - 1;i++) {
//            for (int j = 0 ; j < list.size() - 2;j++) {
//                Integer now = list.get(j);
//                Integer next = list.get(j + 1);
//                if (now > next) {
//                    list.set(j,next);
//                    list.set(j+1,now);
//                }
//            }
//        }
//
//        System.out.println(list);

        int a[] = new int[11];
        for (Integer item
                : list
             ) {
            a[item]++;
        }
        for (int i = 0; i < a.length;i++) {
            int count = a[i];
            if (count > 0) {
                for (int j = 0 ; j < count;j++){
                    System.out.println(i);
                }
            }
        }
    }



}
