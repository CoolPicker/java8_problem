package com.algorithm;

import java.util.Iterator;

/**
 * 链表实现先进先出队列
 */
public class LinkedQueue<Item> implements Iterable<Item> {
    private Node first; // 指向最早添加的结点的链接
    private Node last; // 指向最近添加的结点的链接
    private int N; // 队列中的元素数量

    private class Node {
        // 定义结点的嵌套类
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enQueue(Item item) {
        // 向表尾添加元素
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    public Item deQueue(){
        // 从表头删除元素
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /**
     * 递归实现
     *
     * 永遇乐 京口北固亭怀古
     * 千古江山 英雄无觅孙仲谋处
     * 舞榭歌台 风流总被雨打风吹去
     * 斜阳草树 寻常巷陌 人道寄奴曾住
     * 想当年 金戈铁马 气吞万里如虎
     * 元嘉草草 封狼居胥 赢得仓皇北顾
     * 四十三年 望中犹记 烽火扬州路
     * 可堪回首 佛狸祠下 一片神鸦社鼓
     * 凭谁问 廉颇老矣 尚能饭否
     */
    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
