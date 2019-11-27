package com.tree;

/**
 * @Description 二叉树的二叉链表存储
 *  二叉链表存储的思想是让每个节点都能记住它的左右两个子节点
 *  为每个节点增加left、right两个指针，分别引用该节点的左右两个子节点
 * @Author nya
 * @Date 2019/11/25 下午2:55
 **/
public class TwoLinkBinTree<E> {

    public static class TreeNode{
        Object data;
        TreeNode left;
        TreeNode right;

        public TreeNode(){}
        public TreeNode(Object data) {
            this.data = data;
        }
        public TreeNode(Object data,TreeNode left,TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private TreeNode root;
    public TwoLinkBinTree(){
        this.root = new TreeNode();
    }

    public TwoLinkBinTree(E data) {
        this.root = new TreeNode(data);
    }

    public TreeNode addNode(TreeNode parent,E data,boolean isLeft) {
        if (parent == null) {
            throw new RuntimeException("node is null");
        }
        if (isLeft && parent.left != null) {
            throw new RuntimeException("left node was already there");
        }
        if (!isLeft && parent.right != null) {
            throw new RuntimeException("right node was already there");
        }
        TreeNode newNode = new TreeNode(data);
        if (isLeft) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
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

    public E parent(TreeNode node) {
        if (node == null) {
            throw new RuntimeException("node is null");
        }
        if (empty()) {
            throw new RuntimeException("tree is empty");
        }

        TreeNode treeNode = inOrder(root, (E) node.data);
        return (E)treeNode.data;
    }

    public TreeNode inOrder(TreeNode node, E data) {
        if (node != null) {
            TreeNode treeNode = inOrder(node.left, data);
            TreeNode treeNode1 = inOrder(node.right, data);
            if ((node.left != null && node.left.data == data) || (node.right != null && node.right.data == data)) {
                return node;
            }
            if (treeNode != null) {
                return treeNode;
            }
            if (treeNode1 != null) {
                return treeNode1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoLinkBinTree<String> binTree = new TwoLinkBinTree<>("root");
        TreeNode second_level_left = binTree.addNode(binTree.root(), "second level left", true);
        TreeNode second_level_right = binTree.addNode(binTree.root(), "second level right", false);
        TreeNode third_level_left_left = binTree.addNode(second_level_left, "third level left left", true);
        TreeNode third_level_left_right = binTree.addNode(second_level_left, "third level left right", false);
        TreeNode third_level_right_left = binTree.addNode(second_level_right, "third level right left", true);
        TreeNode third_level_right_right = binTree.addNode(second_level_right, "third level right right", false);

        System.out.println(binTree.parent(third_level_right_right));
        System.out.println(binTree.parent(third_level_right_left));
        System.out.println(binTree.parent(third_level_left_right));
        System.out.println(binTree.parent(third_level_left_left));
    }



}
