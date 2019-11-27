package com.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 红黑树
 *  红黑树是一个更高效的检索二叉树，因此常常用来实现关联数组。
 *  典型的，JDK提供的TreeMap就是一棵红黑树的实现
 *  红黑树在排序二叉树基础上增加了如下特性：
 *      1.每个节点要么是红色，要么是黑色
 *      2.根节点永远是黑色的
 *      3.所有的叶子节点都是空节点，并且是黑色的
 *      4.每个红色节点的两个子节点都是黑色的
 *      5.从任一节点到其子树中每个叶子节点的路径都包含相同数量的黑色节点
 * @Author nya
 * @Date 2019/11/26 下午4:56
 **/
public class RedBlackTree<T extends Comparable> {

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    static class Node {
        Object data;
        Node parent;
        Node left;
        Node right;

        // 节点默认颜色 黑色
        boolean color = BLACK;

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
                    ", color=" + color +
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

    public RedBlackTree() {
    }

    public RedBlackTree(T o) {
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
                    current = current.right;
                }
            } while (current != null);
            // 创建新节点
            Node newNode = new Node(ele,parent,null,null);
            if (cmp > 0) {
                parent.right = newNode;
            } else {
                parent.left = newNode;
            }
            // 维护红黑树
            fixAfterInsertion(newNode);
        }
    }

    public void remove(T ele) {
        Node target = getNode(ele);
        if (target.left != null && target.right != null) {
            Node s = target.left;
            while (s.right != null) {
                s = s.right;
            }
            target.data = s.data;
            target = s;
        }
        Node replacement = (target.left != null ? target.left : target.right);
        if (replacement != null) {
            replacement.parent = target.parent;
            if (target.parent == null) {
                root = replacement;
            } else if (target == target.parent.left) {
                target.parent.left = replacement;
            } else {
                target.parent.right = replacement;
            }
            if (target.color == BLACK) {
                fixAfterDeletion(replacement);
            }
        } else if (target.parent == null) {
            root = null;
        } else {
            if (target.color == BLACK) {
                fixAfterDeletion(target);
            }
            if (target.parent != null) {
                if (target == target.parent.left) {
                    target.parent.left = null;
                } else if (target == target.parent.right) {
                    target.parent.right = null;
                }
                target.parent = null;
            }
        }
        unlink(target);
    }

    public Node getNode(T ele) {
        Node p = root;
        while (p != null) {
            int cmp = ele.compareTo(p.data);
            if (cmp < 0) {
                p = p.left;
            } else if (cmp > 0) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    public List<Node> breadthFirst(){
        Queue<Node> queue = new ArrayDeque<>();
        List<Node> list = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            list.add(queue.peek());
            Node p = queue.poll();
            if (p.left != null) {
                queue.offer(p.left);
            }
            if (p.right != null) {
                queue.offer(p.right);
            }
        }
        return list;
    }

    // 插入节点后修复红黑树
    private void fixAfterInsertion(Node x) {
        x.color = RED;
        // 知道x节点的父节点不是根，且x的父节点不是红色
        while (x != root && x.parent.color == RED) {
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
                Node y = rightOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x),BLACK);
                    setColor(y,BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == rightOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateLeft(x);
                    }
                    setColor(parentOf(x),BLACK);
                    setColor(parentOf(parentOf(x)),RED);
                    rotateRight(parentOf(parentOf(x)));
                }
            } else {
                Node y = leftOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x),BLACK);
                    setColor(y,BLACK);
                    setColor(parentOf(parentOf(x)),RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == leftOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x),BLACK);
                    setColor(parentOf(parentOf(x)),RED);
                    rotateLeft(parentOf(parentOf(x)));
                }
            }
        }
        root.color = BLACK;
    }

    private void fixAfterDeletion(Node x) {
        while (x != root && colorOf(x) == BLACK) {
            if (x == leftOf(parentOf(x))) {
                Node sib = rightOf(parentOf(x));
                if (colorOf(sib) == RED) {
                    setColor(sib,BLACK);
                    setColor(parentOf(x),RED);
                    rotateLeft(parentOf(x));
                    sib = rightOf(parentOf(x));
                }
                if (colorOf(leftOf(sib)) == BLACK && colorOf(rightOf(sib)) == BLACK) {
                    setColor(sib,RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(rightOf(sib)) == BLACK) {
                        setColor(leftOf(sib),BLACK);
                        setColor(sib,RED);
                        rotateRight(sib);
                        sib = rightOf(parentOf(x));
                    }
                    setColor(sib,colorOf(parentOf(x)));
                    setColor(parentOf(x),BLACK);
                    setColor(rightOf(sib),BLACK);
                    rotateLeft(parentOf(x));
                    x = root;
                }
            } else {
                Node sib = leftOf(parentOf(x));
                if (colorOf(sib) == RED) {
                    setColor(sib,BLACK);
                    setColor(parentOf(x),RED);
                    rotateRight(parentOf(x));
                    sib = leftOf(parentOf(x));
                }
                if (colorOf(rightOf(sib)) == BLACK && colorOf(leftOf(sib)) == BLACK) {
                    setColor(sib,RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(leftOf(sib)) == BLACK) {
                        setColor(rightOf(sib),BLACK);
                        setColor(sib, RED);
                        rotateLeft(sib);
                        sib = leftOf(parentOf(x));
                    }
                    setColor(sib,colorOf(parentOf(x)));
                    setColor(parentOf(x),BLACK);
                    setColor(leftOf(sib),BLACK);
                    rotateRight(parentOf(x));
                    x = root;
                }
            }
        }
        setColor(x,BLACK);
    }

    private boolean colorOf(Node p) {
        return (p == null ? BLACK : p.color);
    }

    private Node parentOf(Node p) {
        return (p == null ? null : p.parent);
    }

    private Node leftOf(Node p) {
        return (p == null ? null : p.left);
    }

    private Node rightOf(Node p) {
        return (p == null ? null : p.right);
    }

    private void setColor(Node p,boolean c) {
        if (p != null) {
            p.color = c;
        }
    }

    private void rotateLeft(Node p) {
        if (p != null) {
            Node r = p.right;
            Node q = r.left;
            p.right = q;
            if (q != null) {
                q.parent = p;
            }
            r.parent = p.parent;
            if (p.parent == null) {
                root = r;
            } else if (p.parent.left == p) {
                p.parent.left = r;
            } else {
                p.parent.right = r;
            }
            r.left = p;
            p.parent = r;
        }
    }

    private void rotateRight(Node p) {
        if (p != null) {
            Node l = p.left;
            Node q = l.right;
            p.left = q;
            if (q != null) {
                q.parent = p;
            }
            l.parent = p.parent;
            if (p.parent == null) {
                root = l;
            } else if (p.parent.right == p) {
                p.parent.right = l;
            } else {
                p.parent.left = l;
            }
            l.right = p;
            p.parent = l;
        }
    }

    // 实现中序遍历
    public List<Node> inIterator() {
        return inIterator(root);
    }

    private List<Node> inIterator(Node node) {
        List<Node> list = new ArrayList<>();
        if (node.left != null) {
            list.addAll(inIterator(node.left));
        }
        list.add(node);
        if (node.right != null) {
            list.addAll(inIterator(node.right));
        }
        return list;
    }

    private T unlink(Node x) {
        Object data = x.data;
        x.parent = x.left = x.right = null;
        x.data = null;
        return (T)data;
    }

}
