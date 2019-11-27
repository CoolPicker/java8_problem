package com.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用测试 - 校验对象是否被回收
 * 虚引用的主要作用就是跟踪对象被垃圾回收的状态，
 * 程序可以通过检查与虚引用关联的引用队列中是否已经包含指定的虚引用，
 * 从而了解虚引用所引用的对象是否即将被回收
 */
public class PhantomReferenceTest {

    public static void main(String[] args) {
        String str = new String("HelloWorld");
        String str1 = new String("HelloBaby");

        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();

        PhantomReference<String> phantomReference = new PhantomReference<>(str,referenceQueue);
        PhantomReference<String> phantomReference1 = new PhantomReference<>(str1,referenceQueue);

        str = null;
        str1 = null;

        // 试图去除虚引用所引用的对象
        // 程序并不能通过虚引用访问被引用的对象，返回null
        System.out.println(phantomReference.get());

        System.gc();
        System.runFinalization();

        // 取出引用队列中最先进入队列中的引用与phantomReference进行比较
        System.out.println(referenceQueue.poll() == phantomReference1);
        System.out.println(referenceQueue.poll() == phantomReference);
    }

}
