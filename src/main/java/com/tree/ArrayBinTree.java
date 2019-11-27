package com.tree;

import java.util.Arrays;

/**
 * @Description 二叉树
 *  与树的区别：
 *      1.二叉树节点的最大度数为2
 *      2.二叉树的节点有左右之分
 *
 * @Author nya
 * @Date 2019/11/25 下午2:20
 **/
public class ArrayBinTree<T> {

    private Object[] datas;
    private int DEFAULT_DEEP = 8;

    private int deep;
    private int arraySize;

    public ArrayBinTree(){
        this.deep = DEFAULT_DEEP;
        this.arraySize = (int)Math.pow(2,deep) - 1;
        datas = new Object[arraySize];
    }

    public ArrayBinTree(int deep) {
        this.deep = deep;
        this.arraySize = (int)Math.pow(2,deep) - 1;
        datas = new Object[arraySize];
    }

    public ArrayBinTree(int deep,T data) {
        this.deep = deep;
        this.arraySize = (int)Math.pow(2,deep) - 1;
        datas = new Object[arraySize];
        datas[0] = data;
    }

    public void add(int index,T data,boolean left) {
        if (datas[index] == null) {
            throw new RuntimeException(index + " node is null");
        }
        if (2 * index + 1 >= arraySize) {
            throw new RuntimeException("tree is full");
        }
        if (left) {
            datas[2 * index + 1] = data;
        } else {
            datas[2 * index + 2] = data;
        }
    }

    public boolean empty(){
        return datas[0] == null;
    }

    public T root(){
        return (T)datas[0];
    }

    public T parent(int index) {
        return (T)datas[(index - 1) / 2];
    }

    public T left(int index) {
        if (2 * index + 1 > arraySize) {
            throw new RuntimeException("leaf node , no child node");
        }
        return (T)datas[index * 2 + 1];
    }

    public T right(int index) {
        if (2 * index + 2 > arraySize) {
            throw new RuntimeException("leaf node, no child node");
        }
        return (T)datas[index * 2 + 2];
    }

    public int deep(int index) {
        return deep;
    }

    public int pos(T data) {
        for (int i = 0 ; i < arraySize ; i++) {
            if (datas[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(datas);
    }
}
