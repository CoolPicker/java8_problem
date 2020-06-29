package com.leetcode;

/**
 * @Description
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @Author nya
 * @Date 2020/6/29 下午1:25
 **/
public class AddTwoNumbers2 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        AddTwoNumbers2 numbers = new AddTwoNumbers2();
        ListNode node = numbers.addTwoNumbers(listNode1, listNode4);
        System.out.println(node);
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int item = 0;
        StringBuilder sb = new StringBuilder();
        while (l1 != null || l2 != null) {
            int addOne = 0;
            int addTwo = 0;
            if (l1 != null) {
                addOne = l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                addTwo = l2.val;
                l2 = l2.next;
            }
            int here;
            if (addOne + addTwo + item >= 10) {
                here = (addOne + addTwo + item) %10;
                item = 1;
            } else {
                here = addOne + addTwo + item;
                item = 0;
            }

            if (l1 == null && l2 == null) {
                sb.append(here);
                if (item == 1) {
                    sb.append(item);
                }
            } else {
                sb.append(here);
            }
        }
        String s = sb.toString();
        String[] split = s.split("");
        ListNode node = null;
        ListNode beforeNode = null;
        for (int i = 0 ; i < s.length();i++) {
            int parseInt = Integer.parseInt(split[i]);
            if (i == 0) {
                node = new ListNode(parseInt);
                beforeNode = node;
            } else {
                ListNode listNode = new ListNode(parseInt);
                beforeNode.next = listNode;
                beforeNode = listNode;
            }
        }

        return node;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
