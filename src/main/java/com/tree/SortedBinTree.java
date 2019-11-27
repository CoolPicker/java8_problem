package com.tree;

/**
 * @Description 排序二叉树
 *  排序二叉树具有下列性质：
 *      1.若它的左子树不空，则左子树上所有节点的值均小于它的根节点的值
 *      2.若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值
 *      3.它的左右子树也分别为排序二叉树
 * @Author nya
 * @Date 2019/11/26 上午10:58
 **/
public class SortedBinTree<T extends Comparable> {
    static class Node {
        Object data;
        Node parent;
        Node left;
        Node right;
        public Node(Object data,Node parent,Node left,Node right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object.getClass() == Node.class) {
                Node target = (Node) object;
                return data.equals(target.data)
                        && left == target.left
                        && right == target.right
                        && parent == target.parent;
            }
            return false;
        }
    }

    private Node root;
    public SortedBinTree(){
        root = null;
    }
    public SortedBinTree(T o) {
        root = new Node(o,null,null,null);
    }

    public void add(T ele) {
        if (root == null) {
            root = new Node(ele,null,null,null);
        } else {
            Node current = root;
            Node parent = null;
            int cmp = 0;
            // 搜索合适的叶子节点，以该叶子节点作为父节点添加新节点
            do {
                parent = current;
                cmp = ele.compareTo(current.data);
                if (cmp > 0) {
                    current = current.right;
                } else {
                    current = current.left;
                }
            } while (current != null);
            Node newNode = new Node(ele,parent,null,null);
            if (cmp > 0) {
                parent.right = newNode;
            } else {
                parent.left = newNode;
            }

        }
    }

    public void remove(T ele) {
        Node target = getNode(ele);
        // 如果要删除的节点为null，则直接返回
        if (target == null) {
            return;
        }
        // 如果要删节点的左右子树为空
        if (target.left == null && target.right == null) {
            if (target == root) {
                root = null;
            } else {
                // 要删除节点时父节点的左子节点
                if (target == target.parent.left) {
                    target.parent.left = null;
                } else {
                    target.parent.right = null;
                }
            }
        // 如果要删除节点只有右子树
        } else if (target.left == null) {
            if (target == root) {
                root = target.right;
            } else {
                if (target == target.parent.left) {
                    target.parent.left = target.right;
                } else {
                    target.parent.right = target.right;
                }
                target.right.parent = target.parent;
            }
        } else if (target.right == null) {
            if (target == root) {
                root = target.left;
            } else {
                if (target == target.parent.left) {
                    target.parent.left = target.left;
                } else {
                    target.parent.right = target.left;
                }
                target.left.parent = target.parent;
            }
        // 如果要删除节点既有左子树，又有右子树
        } else {
            // leftMaxNode 用于保存target节点的左子树中值最大的节点
            Node leftMaxNode = target.left;
            // 搜索target节点的左子树中值最大的节点
            while (leftMaxNode.right != null) {
                leftMaxNode = leftMaxNode.right;
            }
            // 从原来的子树中删除leftMaxNode节点
            leftMaxNode.parent.right = null;
            leftMaxNode.parent = target.parent;
            if (target == target.parent.left) {
                target.parent.left = leftMaxNode;
            } else {
                target.parent.right = leftMaxNode;
            }
            leftMaxNode.left = target.left;
            leftMaxNode.right = target.right;
        }
    }

    public Node getNode(T ele) {
        Node p = root;
        while (p != null) {
            int cmp = ele.compareTo(p.data);
            if (cmp < 0) {
                p = p.left;
            } else if (cmp > 0){
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }
}
