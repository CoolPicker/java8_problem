package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @Author nya
 * @Date 2020/10/27 上午10:07
 **/
public class PreOrderTraversal144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        preOrder(root,res);
        return res;
    }

    private void preOrder(TreeNode root,List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preOrder(root.left,res);
        preOrder(root.right,res);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
