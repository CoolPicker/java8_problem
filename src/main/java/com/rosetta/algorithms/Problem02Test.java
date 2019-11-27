package com.rosetta.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Test for problem02
 */
public class Problem02Test {

    public static void main(String[] args) {

        LinkNode first = new LinkNode(2,new LinkNode(9,new LinkNode(9,null)));
        LinkNode second = new LinkNode(9,new LinkNode(7,new LinkNode(1,null)));

        List<Integer> res = new ArrayList<>();
        int decade = 0;
        while (first != null && second != null) {
            int val1 = first.value;
            int val2 = second.value;
            first = first.linkNode;
            second = second.linkNode;
            int now = val1 + val2 + decade;
            if (now >= 10) {
                decade = now / 10;
                now = now % 10;
            } else {
                decade = 0;
            }
            res.add(now);
        }
        System.out.println(res);

    }



    private static class LinkNode {
        int value;
        LinkNode linkNode;

        public LinkNode(int value,LinkNode linkNode) {
            this.value = value;
            this.linkNode = linkNode;
        }

        public LinkNode(){}

        @Override
        public String toString() {
            return "LinkNode{" +
                    "value=" + value +
                    ", linkNode=" + linkNode +
                    '}';
        }
    }
}
