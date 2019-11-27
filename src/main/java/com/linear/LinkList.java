package com.linear;

/**
 * @Description 链式存储结构
 *  链表将采用一组地址任意的存储单元存放线性表中的数据元素。
 *
 * @Author nya
 * @Date 2019/11/14 上午9:34
 **/
public class LinkList<T> {

    private class Node{
        private T data;
        private Node next;
        public Node(){}
        public Node(T data,Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node header;
    private Node tail;
    private int size;

    public LinkList(){
        header = null;
        tail = null;
    }

    public LinkList(T element) {
        header = new Node(element,null);
        tail = header;
        size++;
    }

    public int length(){
        return size;
    }

    public T get(int index) {
        return getNodeByIndex(index).data;
    }

    private Node getNodeByIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        Node current = header;
        for (int i = 0 ; i < size && current != null ; i++,current = current.next) {
            if (i == index) {
                return current;
            }
        }
        return null;
    }

    public int locate(T element) {
        Node current = header;
        for (int i = 0 ; i < size && current != null ; i++,current = current.next) {
            if (current.data.equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public void insert(int index,T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        if (header == null) {
            add(element);
        } else {
            if (index == 0) {
                addAtHeader(element);
            } else {
                Node prev = getNodeByIndex(index - 1);
                prev.next = new Node(element,prev.next);
                size++;
            }
        }
    }

    public void add(T element) {
        if (header == null) {
            header = new Node(element,null);
            tail = header;
        } else {
            Node newNode = new Node(element,null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addAtHeader(T element) {
        header = new Node(element,header);
        if (header == null) {
            tail = header;
        }
        size++;
    }

    public T delete(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        Node del = null;
        if (index == 0) {
            del = header;
            header = header.next;
        } else {
            Node prev = getNodeByIndex(index-1);
            del = getNodeByIndex(index);
            prev.next = del.next;
            del.next = null;
        }
        size--;
        return del.data;
    }

    public T remove(){
        return delete(size - 1);
    }

    public boolean empty(){
        return size == 0;
    }

    public void clear(){
        header = null;
        tail = null;
        size = 0;
    }

    public String toString(){
        if (size == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (Node current = header;current != null;current = current.next) {
                sb.append(current.data.toString()+", ");
            }
            int len = sb.length();
            return sb.delete(len-2,len).append("]").toString();
        }
    }

    public static void main(String[] args) {
        LinkList<String> list = new LinkList<>();
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
