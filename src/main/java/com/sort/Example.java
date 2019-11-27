package com.sort;

/**
 * 比较两种算法：
 *     1.实现并调试
 *     2.分析其基本性质
 *     3.对其相对性能作出猜想
 *     4.用实验验证猜想
 *
 * 排序可分为内部排序和外部排序：
 *  如果整个排序过程不需要借助外部存储器，所有排序操作都在内存中完成 --- 内部排序
 *  如果参与排序的数据元素的数据量非常大，计算机无法把整个排序过程放在内存中完成，
 *      必须借助外部存储器 --- 外部排序
 *  外部排序最常用的算法时多路归并排序，即将原文件分解成多个能够一次性装入内存的部分，
 *  分别把每一部分调入内存完成排序，接下来在对多个有序的子文件进行归并排序。
 *
 *  内部排序：
 *      选择排序 = 直接选择排序，堆排序
 *      交换排序 = 冒泡排序、快速排序
 *      插入排序 = 直接插入排序、折半插入排序、shell排序
 *      归并排序
 *      桶式排序
 *      基数排序
 *
 *
 */
public class Example {

    public static void sort(Comparable[] a) {}

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
        String[] mm = new String[]{"s","o","r","t","e","x","a","m","p","l","e"};
        String[] tt = mm.clone();
        // 选择排序
        SelectionSort.sort(tt);
        for (String a :
                tt) {
            System.out.print(a + " ");
        }

        System.out.println("");

        String[] tt1 = mm.clone();

        InsertionSort.sort(tt1);

        for (String a :
                tt1) {
            System.out.print(a + " ");
        }

        System.out.println("");

        String[] tt2 = mm.clone();
        ShellSort.sort(tt2);
        for (String a:tt2) {
            System.out.print(a + " ");
        }
        System.out.println("");

        String[] tt3 = mm.clone();
        MergeSort.sort(tt3);
        for (String a:tt3) {
            System.out.print(a + " ");
        }
        System.out.println("");

        String[] tt4 = mm.clone();
        MergeSort.sortBottomUpper(tt4);
        for (String a:tt4) {
            System.out.print(a + " ");
        }
        System.out.println("");

        String[] tt5 = mm.clone();
        QuickSort.sort(tt5);
        for (String a : tt5) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

}
