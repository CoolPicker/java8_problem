package com.leetcode;

/**
 * @Description
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @Author nya
 * @Date 2020/7/3 下午2:29
 **/
public class SortArray2BST108 {

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        SortArray2BST108 bst = new SortArray2BST108();
        System.out.println(bst.sortedArrayToBST(nums));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayToTree(nums,0,nums.length-1);
    }

    private TreeNode arrayToTree(int[] nums,int left,int right) {
        if (left > right) return null;
        int mid = (right + left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = arrayToTree(nums,left,mid-1);
        node.right = arrayToTree(nums,mid + 1,right);
        return node;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}
