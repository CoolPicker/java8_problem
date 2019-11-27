package com.rosetta.ninetynine_problems._01_lists;

import java.util.Arrays;

public class StaticSEofInts {
    private int[] a;
    public StaticSEofInts(int[] keys) {
        a = new int[keys.length];
        // 保护性复制目标数组
        for (int i = 0 ; i < keys.length; i++) {
            a[i] = keys[i];
        }
        Arrays.sort(a);
    }
    public boolean contains(int key) {
        return rank(key) != -1;
    }

    // 二分查找
    private int rank(int key) {
        int lo = 0;
        int hi = a.length - 1;
        // 键要么存在于a[lo..hi]中,要么不存在
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
