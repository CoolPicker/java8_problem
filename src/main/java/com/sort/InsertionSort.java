package com.sort;

/**
 * 插入排序：
 *      将元素插入适当位置，同时，为给要插入的元素腾出空间，
 *      需将其余所有元素在插入之前都向右移动一位。
 * 插入排序对于实际应用中常见的某些类型的非随机数组很有效。
 *   几种典型的部分有序的数组：
 *       1.数组中每隔元素距离它的最终位置都不远；
 *       2.一个有序的大数组接一个小数组；
 *       3.数组中只有几个元素的位置不正确
 *
 * 速度提升策略：
 *     在内循环中将较大的元素都向右移动而不总是交换两个元素。
 *
 * 运行时间 -- 线性的
 * @author niuya
 */
public class InsertionSort {

    public static void sort(Comparable[] a) {
        // 将a[]按升序排列
        int N = a.length;
        for (int i = 1; i < N;i++) {
            // 将 a[i] 插入到 a[i-1]/a[i-2]/a[i-3]...之中
            for (int j = i; j > 0 && less(a[j],a[j-1]);j--) {
                exchange(a,j,j-1);
            }
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
