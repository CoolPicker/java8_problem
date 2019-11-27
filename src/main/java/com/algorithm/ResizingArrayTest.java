package com.algorithm;

public class ResizingArrayTest {

    public static void main(String[] args) {
        ResizingArrayStack<String> arrayStack = new ResizingArrayStack<>();
        arrayStack.push("hello");
        arrayStack.push("how are you");
        arrayStack.push("I love you");
        arrayStack.push("yeah");
        int length = arrayStack.size();
        // 迭代的过程中，需注意栈长度的变化
        for (int i = 0 ; i < length; i++) {
            System.out.println(arrayStack.pop());
        }

        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.push(4);
        linkedStack.push(5);
        int size = linkedStack.size();
        for (int i = 0 ; i < size; i++) {
            System.out.println(linkedStack.pop());
        }

        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        linkedQueue.enQueue(11);
        linkedQueue.enQueue(22);
        linkedQueue.enQueue(33);
        linkedQueue.enQueue(44);
        linkedQueue.enQueue(55);
        int sizeQueue = linkedQueue.size();
        for (int i = 0; i < sizeQueue; i++) {
            System.out.println(linkedQueue.deQueue());
        }

    }


}
