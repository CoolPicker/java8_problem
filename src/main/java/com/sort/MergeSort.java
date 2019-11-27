package com.sort;

/**
 * 归并排序：
 *    自顶向下的归并排序
 *
 * 归并排序所需的时间和NlgN成正比。可用以处理数百万甚至更大规模的数组。
 * 缺点：辅助数组所使用的额外空间和N的大小成正比
 * @author lab
 */
public class MergeSort {

    private static final ThreadLocal<Comparable[]> aux = ThreadLocal.withInitial(() -> new Comparable[0]);

    /**
     * 自底向上的归并排序
     * @param a
     */
    public static void sortBottomUpper(Comparable[] a) {
        // 进行lgN次两两归并
        int N = a.length;
        aux.set(new Comparable[N]);
        // sz子数组大小
        for (int sz = 1;sz < N; sz += sz) {
            // lo:子数组索引
            for (int lo = 0; lo < N - sz; lo+=sz+sz) {
                merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
            }
        }
    }

    public static void sort(Comparable[] a) {
        // 一次性分配空间
        aux.set(new Comparable[a.length]);
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int lo,int hi) {
        // 将数组a[lo..hi]排序
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        // 将左半边排序
        sort(a,lo,mid);
        // 将右半边排序
        sort(a,mid+1,hi);
        // 归并结果
        merge(a,lo,mid,hi);
    }

    private static void merge(Comparable[] a,int lo,int mid,int hi){
        // 将a[lo..mid]和a[mid+1..hi]归并
        int i = lo,j = mid+1;
        // 将a[lo..hi]复制到aux[lo..hi]
        for (int k = lo; k <= hi; k++) {
            aux.get()[k] = a[k];
        }
        // 归并回到a[lo..hi]
        for (int k = lo;k <= hi;k++) {
            if (i > mid) {
                a[k] = aux.get()[j++];
            } else if (j > hi) {
                a[k] = aux.get()[i++];
            } else if (less(aux.get()[j], aux.get()[i])) {
                a[k] = aux.get()[j++];
            } else {
                a[k] = aux.get()[i++];
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
