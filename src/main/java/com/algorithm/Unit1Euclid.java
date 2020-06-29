package com.algorithm;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * @Description 欧几里得算法
 * 计算两个非负整数p和q的最大公约数:
 *  若q是0, 则最大公约数为p. 否则, 将p除以q得到余数r, p和q的最大公约数即为q和r的最大公约数.
 *
 *  在计算机科学领域, 用算法来描述一种有限,确定,有效的并适合用计算机程序来实现的解决问题的方法.
 *  算法是计算机科学的基础, 是这个领域研究的核心.
 *  数据结构也是计算机科学研究的核心对象, 它和算法的关系非常密切.
 *
 * @Author nya
 * @Date 2020/6/17 下午2:15
 **/
public class Unit1Euclid {

    public static void main(String[] args) {
        int a = 25;
        int b = 50;
        System.out.println(gcd(a,b));
        double m = 14169.9 * 1000 / 1089;
        double n = 1528.7 * 1000 / 1093;
        System.out.println(n /m);

        int[] array = {0,1,2,3,4,5,6,7,8,9,10};
        int key = 5;
        System.out.println(rank(key,array));
        System.out.println(binarySearch(key,array));

        System.out.println(1.0/0.0); // 无穷大

        Calendar now = Calendar.getInstance();
        now.set(Calendar.HOUR_OF_DAY,9);
        now.set(Calendar.MINUTE,30);
        now.set(Calendar.SECOND,0);
        long today = now.getTimeInMillis();
        now.add(Calendar.DAY_OF_YEAR,-1);
        long yesterday = now.getTimeInMillis();
        System.out.println(today);
        System.out.println(yesterday);

        JSONObject jsonObject = new JSONObject();
        String aaa = jsonObject.getString("aaa");
        System.out.println("["+aaa+"]");

        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9);
        intList = new ArrayList<>(intList);
        List<Integer> heiHeiHei = intList;
        intList.add(11);
        System.out.println(intList);
        System.out.println(heiHeiHei);

        StopWatch started = StopWatch.createStarted();
        for (int i = 0 ; i < 50000; i++) {

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        started.stop();
        System.out.println(started.getTime());

        List list = new ArrayList();
        list.add("aaa");
        list.add(111);
        list.add('a');
        list.forEach(item -> {
            if (item instanceof  Integer) {
                System.out.println(item + " --- Integer");
            } else if (item instanceof Character) {
                System.out.println(item + " --- Character");
            } else if (item instanceof String) {
                System.out.println(item + " --- String");
            }
        });
    }

    private static int gcd(int p, int q) {
        int min = Math.min(p, q);
        int max = Math.max(p, q);
        if (min < 0) return 0;
        if (min == 0) return max;
        int r = max % min;
        return gcd(min,r);
    }

    private static int rank(int key, int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] > key) end = mid - 1;
            else if (array[mid] < key) start = mid + 1;
            else return mid;
        }
        return -1;
    }

    private static int binarySearch(int key, int[] array) {
        return binarySearch(key,array,0,array.length - 1);
    }
    private static int binarySearch(int key,int[] array, int lo,int hi) {
        if (hi < lo) return -1;
        int mid = lo + (hi - lo) / 2;
        if (array[mid] > key) return binarySearch(key,array,lo,mid - 1);
        else if (array[mid] < key) return binarySearch(key,array,mid + 1, hi);
        else return mid;
    }
}


