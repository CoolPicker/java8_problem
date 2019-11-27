package com.sort;

/**
 * 选择排序 -- 不断地选择剩余元素之中的最小者
 *      首先，找到数组中最小的那个元素，
 *      其次，将它和数组的第一个元素交换位置。
 *      再次，在剩下的元素中找到最小的元素，
 *          将它与数组的第二个元素交换位置。
 *
 * 运行时间 -- 平方级别
 */
public class SelectionSort {

    public static void sort(Comparable[] a) {
        // 将a[] 按升序排序
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j],a[min])) min = j;
            }
            exchange(a,i,min);
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

    public static void main(String[] args) {

    }

}
