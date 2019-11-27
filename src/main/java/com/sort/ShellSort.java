package com.sort;

/**
 * 希尔排序： 一种基于插入排序的快速的排序算法
 *     希尔排序的思想是使数组中任意间隔为h的元素都是有序的。
 *     这样的数组被称为h有序数组。
 *
 * @author lab
 */
public class ShellSort {

    public static void sort(Comparable[] a) {
        // 将a[]按升序排列
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = 3*h + 1;
        }
        while (h >= 1) {
            // 将数组变为h有序
            for (int i = h; i < N; i++) {
                // 将a[i]插入到a[i-h]，a[i-2*h]，a[i-3*h]...之中
                for (int j = i; j >= h && less(a[j],a[j-h]); j-=h) {
                    exchange(a,j,j-h);
                }
            }
            h = h/3;
        }
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exchange(Comparable[] a,int i , int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0 ; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i],a[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
