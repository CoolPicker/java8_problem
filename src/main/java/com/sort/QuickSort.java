package com.sort;

/**
 * 快速排序：
 *     特点：
 *          原地排序（只需要一个很小的辅助栈）
 *          长度为N的数组排序所需时间和NlgN成正比
 *     快速排序是一种分治的排序算法。
 *     它将一个数组分成两个子数组，将两部分独立地排序。
 *     快速排序和归并排序是互补的：
 *     归并排序将数组分成两个子数组分别排序，并将有序的子数组归并以将整个数组排序。
 *     快速排序则是当两个子数组都有序时整个数组也就自然有序了。
 *     归并排序时，递归调用发生在处理整个数组之前；
 *     快速排序时，递归调用发生在处理整个数组之后。
 *     在归并排序中，一个数组被等分为两半；
 *     在快速排序中，切分（partition）的位置取决于数组的内容。
 *
 *  快速排序 - 思路：
 *      从待排序的数据序列中任取一个数据作为分界值，所有比它小的数据元素一律放到左边，
 *      所有比它大的数据元素一律放到右边。经过这样一趟下来，该序列形成左、右两个子序列，
 *      左边序列中数据元素的值都比分界值小，右边序列中数据元素的值都比分界值大。
 *      接下来对左、右两个子序列进行递归，对两个子序列重新选择中心元素并以此规则调整，
 *      直到每个子序列的元素只剩一个，排序完成。
 */
public class QuickSort {

    public static void sort(Comparable[] a) {
        sort(a,0,a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static int partition(Comparable[] a,int lo, int hi) {
        // 将数组切分为 a[lo..i-1],a[i],a[i+1..hi]
        // 左右扫描指针
        int i = lo, j = hi+1;
        // 切分元素
        Comparable v = a[lo];
        while (true) {
            // 扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i],v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v,a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(a,i,j);
        }
        // 将 v = a[j] 放入正确的位置
        exchange(a,lo,j);
        // a[lo..j-1] <= a[j] <= a[j+1..hi] 达成
        return j;
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
        int v = (int)(((double) 720 / 777) * 633);
        System.out.println(v);
        int v1 = (int) v;
        System.out.println(v1);
    }

}
