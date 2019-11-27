package com.expression;

/**
 *  关于字符串的陷阱
 *
 *  String java = new String("Hello World!");
 *  创建了两个字符串对象：
 *      一个是 Hello World！ 这个直接量对应的字符串对象
 *      一个是由new String() 构造器返回的字符串对象
 *
 *  当程序中需要使用字符串、基本类型包装类实例时，
 *  应该尽量使用字符串直接量、基本类型的直接量，
 *  避免通过new String()/new Integer()的形式来创建对象，
 *  这样能保证较好的性能。
 *
 *  Java程序中创建对象的常见方式有如下4种：
 *      通过new调用构造器创建Java对象
 *      通过Class对象的newInstance()方法调用构造器创建Java对象
 *      通过Java的反序列化机制从IO流中恢复Java对象
 *      通过Java对象提供的clone()方法复制一个新的Java对象
 */
public class StringTest {

    public static void main(String[] args) {
        String a = new String("aabbcc");
        String b = "aabbcc";
        String c = "aabbcc";
        System.out.println(a == b);
        System.out.println(b == c);

        /**
         * 此处引用类型变量str - 指向不同的String对象
         * String类是一个典型的不可变类
         */
        String str = "Hello ";
        System.out.println(System.identityHashCode(str));
        str = str + "Tom ";
        System.out.println(System.identityHashCode(str));
        str = str + "& Jerry";
        System.out.println(System.identityHashCode(str));



    }

}
