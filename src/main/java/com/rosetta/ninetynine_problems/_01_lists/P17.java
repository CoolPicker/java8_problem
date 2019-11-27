package com.rosetta.ninetynine_problems._01_lists;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

/**
 * <b>(*) Split a list into two parts; the length of the first part is given</b>
 */
public class P17 {

    public static <T> Map<Boolean, List<T>> split(List<T> list, int n) {
        return IntStream
                .range(0, list.size())
                .mapToObj(i -> new SimpleEntry<>(i, list.get(i)))
                .collect(partitioningBy(entry -> entry.getKey() < n, mapping(SimpleEntry::getValue, toList())));
    }

    /**
     * 求取平方根
     * @param c 输入值 - double类型
     * @return 返回平方根 double类型
     */
    public static double sqrt(double c) {
        if (c < 0) return Double.NaN;
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c/t) > err * t)
            t = (c/t + t) / 2.0;
        return t;
    }

    /**
     * 二分查找的递归实现
     * @param key 查询的值
     * @param a 整数数组
     * @return 返回索引位置
     */
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }

    public static int rank(int key, int[] a, int lo, int hi){
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi);
        else return mid;
    }

    /**
     * 二分查找的循环实现
     * @param key 需要查找的元素
     * @param a 目标数组
     * @return 返回索引位置,不存在则为 -1
     */
    public static int seek(int key, int[] a) {
        // 数组必须是有序的
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // 被查找的键要么不存在,要么必然存在于a[lo..hi]之中
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(sqrt(4.0));
//        int[] a = {2, 5, 6, 9, 12};
//        System.out.println(rank(9,a));
//        System.out.println(seek(2,a));
        System.out.println(tenToBinary(128));
        System.out.println(exR2(5));
    }

    public static String tenToBinary(int i) {
        String res = "";
        for (int n = i; n> 0; n /= 2) {
            res = (n % 2) + res;
        }
        return res;
    }

    public static String exR2(int n) {
        if (n <= 0) return "";
        String s = exR2(n - 3) + n + exR2(n - 2) + n;
        return s;
    }
}
