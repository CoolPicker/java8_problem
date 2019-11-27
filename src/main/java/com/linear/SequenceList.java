package com.linear;

import java.util.Arrays;

/**
 * @Description 线性表
 *  对于一个非空、有限的线性表而言，具有如下基本特征：
 *      1.总存在唯一的“第一个”数据元素
 *      2.总存在唯一的“最后一个”数据元素
 *      3.除第一个数据元素外，集合中的每一个数据元素都只有一个前驱的数据元素
 *      4.除最后一个数据元素外，集合中的每一个数据元素都只有一个后继的数据元素
 *
 *  线性表的基本操作：
 *      1.初始化
 *      2.返回线性表的长度
 *      3.获取指定索引处的元素
 *      4.按值查找数据元素的位置
 *      5.直接插入数据元素
 *      6.删除线性表中指定位置的数据元素
 *      7.判断线性表是否为空
 *      8.清空线性表
 *
 *  线性表的顺序存储结构是指用一组地址连续的存储单元一次存放线性表的元素。
 *  当程序采用顺序存储结构来实现线性表时，线性表中相邻元素的两个元素对应的存储地址也是相邻的。
 *
 *  线性表的两种实现对比：
 *      A：空间性能
 *          1.顺序表：
 *              顺序表的存储空间时静态分布的，因此需要一个长度固定的数组，因此总有部分数组元素被浪费
 *          2.链表：
 *              链表的存储空间是动态分布的，因此空间不会被浪费。
 *              但由于链表需要额外的空间为每个节点保存指针，也要牺牲部分空间
 *      B：时间性能
 *          1.顺序表：
 *              顺序表中元素的逻辑顺序与物理存储顺序保持一致，而且支持随机存取，
 *              因此顺序表在查找、读取时性能很好
 *          2.链表：
 *              链表采用链式结构来保存表内元素，因此在插入、删除元素时性能较好
 *
 *  队列 - 双端队列：
 *      Deque 继承自 Queue + Stack
 *      既可以当队列使用，也可以当栈使用
 *      JDK为Deque提供了ArrayDeque、LinkedList两个实现类。
 *      其中ArrayDeque代表顺序存储结构的双端队列，
 *      LinkedList则代表链式存储结构的双端队列 - Java集合框架中方法最多的类。
 *      大部分程序中，使用ArrayList、ArrayDeque的性能优于LinkedList
 * @Author nya
 * @Date 2019/11/13 上午11:48
 **/
public class SequenceList<T> {
    private int DEFAULT_SIZE = 16;
    // 保存数组的长度
    private int capacity;
    // 定义一个数组用于保存顺序线性表的元素
    private Object[] elementData;
    // 保存顺序线性表中元素的当前个数
    private int size = 0;

    public SequenceList(){
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    public SequenceList(T element) {
        this();
        elementData[0] = element;
        size++;
    }

    public SequenceList(T element,int initSize) {
        capacity = 1;
        while (capacity < initSize) {
            capacity <<= 1;
        }
        elementData = new Object[capacity];
        elementData[0] = element;
        size++;
    }

    public int length(){
        return size;
    }

    public T get(int i) {
        if (i < 0 || i > size - 1) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        return (T)elementData[i];
    }

    public int locate(T element) {
        for (int i = 0 ; i < size; i++) {
            if (elementData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public void insert(int index,T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        ensureCapacity(size + 1);
        System.arraycopy(elementData,index,elementData,
                index + 1,size - index);
        elementData[index] = element;
        size++;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > capacity) {
            while (capacity < minCapacity) {
                capacity <<= 1;
            }
            elementData = Arrays.copyOf(elementData,capacity);
        }
    }

    public void add(T element) {
        insert(size,element);
    }

    public T delete(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        T oldValue = (T) elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData,index+1,
                    elementData,index,numMoved);
        }
        elementData[--size] = null;
        return oldValue;
    }

    public T remove(){
        return delete(size-1);
    }

    public boolean empty(){
        return size == 0;
    }

    public void clear(){
        Arrays.fill(elementData,null);
        size = 0;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0 ; i < size ;i++) {
                sb.append(elementData[i].toString() + ", ");
            }
            int len = sb.length();
            return sb.delete(len - 2, len).append("]").toString();
        }
    }

    public static void main(String[] args) {
        SequenceList<String> list = new SequenceList<>();
        list.add("am");
        list.add("big");
        list.add("cat");
        list.add("decide");
        list.delete(2);
        System.out.println(list);
        list.insert(0,"good");
        System.out.println(list.locate("decide"));
        System.out.println(list);
    }
}
