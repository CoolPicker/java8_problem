package com.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 树
 *  父节点表示法的思想是让每个节点记住其父节点的索引，从子节点着手
 *  子节点链表示法，让父节点记住它的所有子节点，从父节点着手
 *  子节点链表示法：
 *      需要为每个节点维护一个子节点链，通过该子节点链来记录该节点的所有子节点。
 * @Author nya
 * @Date 2019/11/25 上午11:06
 **/
public class TreeChild<E> {

    private static class SonNode{
        private int pos;
        private SonNode next;
        public SonNode(int pos,SonNode next) {
            this.pos = pos;
            this.next = next;
        }

        @Override
        public String toString() {
            return "SonNode{" +
                    "pos=" + pos +
                    ", next=" + next +
                    '}';
        }
    }

    public static class Node<T> {
        T data;
        SonNode first;
        public Node(T data) {
            this.data = data;
            this.first = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", first=" + first +
                    '}';
        }
    }

    private final int DEFAULT_TREE_SIZE = 100;
    private int treeSize = 0;
    private Node<E>[] nodes;
    private int nodeNums;

    public TreeChild(E data) {
        treeSize = DEFAULT_TREE_SIZE;
        nodes = new Node[treeSize];
        nodes[0] = new Node<>(data);
        nodeNums++;
    }

    public TreeChild(E data,int treeSize) {
        this.treeSize = treeSize;
        nodes = new Node[treeSize];
        nodes[0] = new Node<>(data);
        nodeNums++;
    }

    public void addNode(E data,Node parent) {
        for (int i = 0 ; i < treeSize; i++) {
            if (nodes[i] == null) {
                nodes[i] = new Node<>(data);
                if (parent.first == null) {
                    parent.first = new SonNode(i,null);
                } else {
                    SonNode next = parent.first;
                    while (next.next != null) {
                        next = next.next;
                    }
                    next.next = new SonNode(i,null);
                }
                nodeNums++;
                return;
            }
        }
        throw new RuntimeException("this tree is full, can not add new node");
    }

    public boolean empty(){
        return nodes[0] == null;
    }

    public Node<E> root(){
        return nodes[0];
    }

    public List<Node<E>> children(Node parent) {
        List<Node<E>> list = new ArrayList<>();
        SonNode next = parent.first;
        while (next != null) {
            list.add(nodes[next.pos]);
            next = next.next;
        }
        return list;
    }

    public Node<E> child(Node parent,int index) {
        SonNode next = parent.first;
        for (int i = 0 ; next != null;i++) {
            if (index == i) {
                return nodes[next.pos];
            }
            next = next.next;
        }
        return null;
    }

    public int deep(){
        return deep(root());
    }

    private int deep(Node node) {
        if (node.first == null) {
            return 1;
        } else {
            int max = 0;
            SonNode next = node.first;
            while (next != null) {
                int tmp = deep(nodes[next.pos]);
                if (tmp > max) {
                    max = tmp;
                }
                next = next.next;
            }
            return max + 1;
        }
    }

    public int pos(Node node) {
        for (int i = 0 ; i < treeSize; i++) {
            if (nodes[i] == node) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        TreeChild<String> tree = new TreeChild<>("root");
        Node<String> root = tree.root();
        System.out.println("root : " + root);

        tree.addNode("node 1",root);
        tree.addNode("node 2",root);
        tree.addNode("node 3",root);
        tree.addNode("node 4",root);
        System.out.println("add after root : " + root);
        System.out.println("deep : " + tree.deep());

        List<Node<String>> children = tree.children(root);
        System.out.println("first : " + children.get(0));

        tree.addNode("node 5",children.get(0));
        System.out.println(children.get(0));
        System.out.println(tree.deep());
    }

}
