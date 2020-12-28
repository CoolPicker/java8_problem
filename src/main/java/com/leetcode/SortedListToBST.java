package com.leetcode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @Author nya
 * @Date 2020/8/18 下午4:36
 **/
public class SortedListToBST {

    private Lock lock = new ReentrantLock();

    private int total = 1000;

    private void drawMoney(){
        lock.lock();
        this.total--;
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        SortedListToBST sort = new SortedListToBST();
        CountDownLatch latch = new CountDownLatch(1000);
        for (int i = 0; i < 1000;i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                    sort.drawMoney();
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        latch.await();
        System.out.println(sort.total);
    }


    public TreeNode sortedListToBST(ListNode head) {


        return null;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
