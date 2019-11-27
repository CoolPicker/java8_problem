package com.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 二叉树的三叉链表存储
 *  三叉链表存储是让每个节点记住其左、右两个子节点，父节点。
 *
 *  遍历二叉树： - 针对采用链表保存二叉树节点的形式
 *      深度优先遍历：先访问到树中最深层次的节点
 *      广度优先遍历：逐层访问每层的节点，先访问跟节点，然后访问第二层的节点
 *    深度优先遍历算法，分为三种：
 *          先序遍历二叉树
 *          中序遍历二叉树
 *          后序遍历二叉树
 *
 * @Author nya
 * @Date 2019/11/25 下午7:30
 **/
public class ThreeLinkBinTree<E> {

    public static class TreeNode{
        Object data;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        public TreeNode(){}
        public TreeNode(Object data) {
            this.data = data;
        }
        public TreeNode(Object data,TreeNode left,TreeNode right,TreeNode parent) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode root;
    public ThreeLinkBinTree(E data) {
        this.root = new TreeNode(data);
    }

    public TreeNode addNode(TreeNode parent,E data,boolean isLeft) {

        if (parent == null) {
            throw new RuntimeException("parent is null");
        }

        if (isLeft && parent.left != null) {
            throw new RuntimeException("left is already absent");
        }

        if (!isLeft && parent.right != null) {
            throw new RuntimeException("right is already absent");
        }

        TreeNode newNode = new TreeNode(data);
        if (isLeft) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        newNode.parent = parent;
        return newNode;
    }

    public boolean empty(){
        return root.data == null;
    }

    public TreeNode root(){
        if (empty()) {
            throw new RuntimeException("tree is empty");
        }
        return root;
    }

    public int deep(){
        return deep(root);
    }

    private int deep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            int leftDeep = deep(node.left);
            int rightDeep = deep(node.right);
            int max = Math.max(leftDeep, rightDeep);
            return max+1;
        }
    }

    /**
     * 先序遍历二叉树指先处理根节点，处理顺序：
     *  1.访问根节点
     *  2.递归遍历左子树
     *  3.递归遍历右子树
     * @return
     */
    public List<TreeNode> preIterator(){
        return preIterator(root);
    }

    private List<TreeNode> preIterator(TreeNode node) {
        List<TreeNode> list = new ArrayList<>();
        list.add(node);
        if (node.left != null) {
            list.addAll(preIterator(node.left));
        }
        if (node.right != null) {
            list.addAll(preIterator(node.right));
        }
        return list;
    }

    /**
     * 中序遍历二叉树指其次处理根节点，其处理顺序如下：
     *  1.递归遍历左子树
     *  2.访问根节点
     *  3.递归遍历右子树
     * @return
     */
    public List<TreeNode> inIterator(){
        return inIterator(root);
    }

    private List<TreeNode> inIterator(TreeNode node) {
        List<TreeNode> list = new ArrayList<>();
        if (node.left != null) {
            list.addAll(inIterator(node.left));
        }
        list.add(node);
        if (node.right != null) {
            list.addAll(inIterator(node.right));
        }
        return list;
    }

    /**
     * 后序遍历二叉树指最后处理根节点，其处理顺序如下：
     *  1.递归遍历左子树
     *  2.递归遍历右子树
     *  3.访问根节点
     * @return
     */
    public List<TreeNode> postIterator(){
        return postIterator(root);
    }

    private List<TreeNode> postIterator(TreeNode node) {
        List<TreeNode> list = new ArrayList<>();
        if (node.right != null) {
            list.addAll(postIterator(node.right));
        }
        if (node.left != null) {
            list.addAll(postIterator(node.left));
        }
        list.add(node);
        return list;
    }

    /**
     * 广度优先遍历：
     *  为了实现广度优先遍历，可以借助于具有FIFO特征的队列来实现：
     *      1.建一个队列，把树的根节点压入队列
     *      2.从队列中弹出一个节点，然后把该节点的左右节点压入队列，如果没有子节点，则说明已到达叶子节点
     *      3.用循环执行第二步，知道队列为空。
     * @return
     */
    public List<TreeNode> breadthFirst(){
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<TreeNode> list = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            list.add(queue.peek());
            TreeNode p = queue.poll();
            if (p.left != null) {
                queue.offer(p.left);
            }
            if (p.right != null) {
                queue.offer(p.right);
            }
        }
        return list;
    }
}
