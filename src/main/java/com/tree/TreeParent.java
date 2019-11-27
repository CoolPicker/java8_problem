package com.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 树
 *  树结构是非线性结构
 *  按节点是否包含子节点来分，节点可分为以下两种：
 *      普通节点：包含子节点的节点
 *      叶子节点：没有子节点的节点，因此叶子节点不可作为父节点
 *  按节点是否具有唯一的父节点来分，节点又可如下两种：
 *      根节点：没有父节点的节点，根节点不可作为子节点
 *      普通节点：具有唯一父节点的节点
 *
 *  与树相关的术语：
 *      节点：树的最基本组成单元，通常包括一个数据元素及若干指针用于指向其它节点
 *      节点的度：节点拥有的子树的个数被称为节点的度（degree）
 *      树的度：树中所有节点的度的最大值就是该树的度
 *      叶子节点
 *      分直接点
 *      子节点、父节点、兄弟节点
 *      节点的层次（level）
 *      树的深度（depth）：树中节点的最大层次值称为树的深度或高度
 *      有序树与无序树
 *      祖先节点
 *      后代节点
 *      森林
 *
 *  树的基本操作：
 *      初始化
 *      为指定节点添加子节点
 *      判断树是否为空
 *      返回根节点
 *      返回指定节点的父节点
 *      返回指定节点的所有子节点
 *      返回指定节点的第i个子节点
 *      返回该树的深度
 *      返回指定节点的位置
 *
 *  实现树的数据结构：
 *      父节点表示法：每个子节点都记录它的父节点
 *      子节点链表示法：每隔非叶子节点通过一个链表来记录它所有的子节点
 * @Author nya
 * @Date 2019/11/25 上午10:08
 **/
public class TreeParent<E> {

    public static class Node<T> {
        T data;
        int parent;
        public Node(){}
        public Node(T data) {
            this.data = data;
        }
        public Node(T data,int parent) {
            this.data = data;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "TreeParent$Node{" +
                    "data=" + data +
                    ", parent=" + parent +
                    '}';
        }
    }

    private final int DEFAULT_TREE_SIZE = 100;
    private int treeSize = 0;
    private Node<E>[] nodes;
    private int nodeNums;

    public TreeParent(E data) {
        treeSize = DEFAULT_TREE_SIZE;
        nodes = new Node[treeSize];
        nodes[0] = new Node<>(data,-1);
        nodeNums++;
    }

    public TreeParent(E data,int treeSize) {
        this.treeSize = treeSize;
        nodes = new Node[treeSize];
        nodes[0] = new Node<>(data,-1);
        nodeNums++;
    }

    public void addNode(E data,Node parent) {
        for (int i = 0 ; i < treeSize;i++){
            if (nodes[i] == null) {
                nodes[i] = new Node<E>(data,pos(parent));
                nodeNums++;
                return;
            }
        }
        throw new RuntimeException("tree is full,can not add new node");
    }

    public boolean empty(){
        return nodes[0] == null;
    }

    public Node<E> root(){
        return nodes[0];
    }

    public Node<E> parent(Node node) {
        return nodes[node.parent];
    }

    public List<Node<E>> children(Node parent) {
        List<Node<E>> list = new ArrayList<>();
        for (int i = 0 ; i < treeSize;i++){
            if (nodes[i] != null && nodes[i].parent == pos(parent)) {
                list.add(nodes[i]);
            }
        }
        return list;
    }

    public int deep(){
        int max = 0 ;
        for (int i = 0 ; i < treeSize && nodes[i] != null ;i++) {
            int def = 1;
            int m = nodes[i].parent;
            while (m != -1 && nodes[m] != null) {
                m = nodes[m].parent;
                def++;
            }
            if (max < def) {
                max = def;
            }
        }
        return max;
    }

    public int pos(Node node) {
        for (int i = 0 ; i < treeSize;i++) {
            if (nodes[i] == node) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        TreeParent<String> tree = new TreeParent<String>("root");
        TreeParent.Node root = tree.root();
        System.out.println(root);

        tree.addNode("node 1",root);
        tree.addNode("node 2",root);

        System.out.println(tree.deep());

        List<TreeParent.Node<String>> children = tree.children(root);
        System.out.println("first child node : " + children.get(0));
        tree.addNode("node 3",children.get(0));
        System.out.println(tree.deep());
    }

}
