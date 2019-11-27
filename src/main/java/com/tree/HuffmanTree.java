package com.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 哈弗曼树
 *  哈弗曼树又被称为最优二叉树，是一种带权路径最短的二叉树。哈弗曼树是二叉树的一种应用，在信息检索中很常用。
 *  节点之间的路径长度：从一个节点到另一个节点之间的分支数量称为两个节点之间的路径长度。
 *  树的路径长度：从根节点到树中每个节点的路径长度之和。
 *  节点的带权路径长度：从该节点到根节点之间的路径长度与节点的权的乘积
 *  树的带权路径长度：树中所有叶子节点的带权路径长度之和
 *  对于哈弗曼树，有一个很重要的定理：
 *      对于具有n个叶子节点的哈弗曼树，一共需要 2n-1 个节点。
 *  创建哈弗曼树：
 *      1.根据给定的n个权值{w1,w2,...wn}构造n棵二叉树的集合F={T1,T2,...Tn}，
 *      F集合中每棵二叉树都只有一个根节点
 *      2.选取F集合中两棵根节点的权值最小的树作为左右子树以构建一棵新的二叉树，
 *      且将新的二叉树的根节点的权值设为左右子树上根节点的权值之和
 *      3.将新的二叉树加入到F集合中，并删除第二步中被选中的两棵树
 *      4.重复第二、三步，直到F集合中只剩下一棵树，即为哈弗曼树
 * @Author nya
 * @Date 2019/11/26 上午9:52
 **/
public class HuffmanTree {

    public static class Node<E> {
        E data;
        double weight;
        Node<E> leftChild;
        Node<E> rightChild;
        public Node(E data,double weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", weight=" + weight +
                    '}';
        }
    }


    public static void main(String[] args) {
        List<Node<String>> nodes = new ArrayList<>();
        nodes.add(new Node<>("A",40.0));
        nodes.add(new Node<>("B",7.0));
        nodes.add(new Node<>("C",10.0));
        nodes.add(new Node<>("D",30.0));
        nodes.add(new Node<>("E",12.0));
        nodes.add(new Node<>("F",2.0));
        Node<String> tree = HuffmanTree.createTree(nodes);
        System.out.println(breadthFirst(tree));
    }


    /**
     * 构建哈弗曼树
     *  1.对List集合中的所有节点进行排序
     *  2.找出List集合中权值最小的两个节点
     *  3.以权值最小的两个节点作为子节点创建新节点
     *  4.从List集合中删除权值最小的两个节点，将新节点添加到List集合中
     * @param nodes 及诶单集合
     * @param <E> 定义泛型（参数中包含泛型，需在返回值前定义，否则不能通过编译）
     * @return 构建出来的哈弗曼树的根节点
     */
    private static <E> Node<E> createTree(List<Node<E>> nodes) {
        // 只要nodes数组中还有两个以上的节点
        while (nodes.size() > 1) {
            quickSort(nodes);
            // 获取权值最小的两个节点
            Node<E> left = nodes.get(nodes.size() - 1);
            Node<E> right = nodes.get(nodes.size() - 2);
            // 生成新节点，新节点的权值为两个子节点的权值之和
            Node<E> parent = new Node<>(null,left.weight + right.weight);
            parent.leftChild = left;
            parent.rightChild = right;
            nodes.remove(nodes.size()-1);
            nodes.remove(nodes.size()-1);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    // 将指定数组的i和j索引处的元素交换
    private static <E> void swap(List<Node<E>> nodes,int i,int j) {
        Node<E> tmp;
        tmp = nodes.get(i);
        nodes.set(i,nodes.get(j));
        nodes.set(j,tmp);
    }

    // 快排，用于对节点进行排序
    private static <E> void subSort(List<Node<E>> nodes,int start,int end) {
        if (start < end) {
            Node base = nodes.get(start);
            int i = start;
            int j = end + 1;
            while (true) {
                while (i < end && nodes.get(++i).weight > base.weight);
                while (j > start && nodes.get(--j).weight <= base.weight);
                if (i < j) {
                    swap(nodes,i,j);
                } else {
                    break;
                }
            }
            swap(nodes,start,j);
            subSort(nodes,start,j-1);
            subSort(nodes,j+1,end);
        }
    }

    public static <E> void quickSort(List<Node<E>> nodes) {
        subSort(nodes,0,nodes.size()-1);
    }

    // 广度优先遍历
    public static List<Node> breadthFirst(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        List<Node> list = new ArrayList<>();
        if (root!=null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            list.add(queue.peek());
            Node p = queue.poll();
            if (p.leftChild != null) {
                queue.offer(p.leftChild);
            }
            if (p.rightChild != null) {
                queue.offer(p.rightChild);
            }
        }
        return list;
    }

}
