package com.flow;

import java.io.*;

/**
 * @Description 内部类
 *  内部类能提供更好的封装，而且它可以直接访问外部类的private成员，
 *  因此在一些特殊场合下更常用
 *
 *  注意 -- 非静态内部类：
 *      1.系统在编译阶段总会为非静态内部类的构造器增加一个参数，非静态内部类的构造器
 *      的第一个形参总是外部类。因此调用非静态内部类的构造器时必须传入一个外部类对象
 *      作为参数，否则程序将会引发运行时异常。
 *      2.对于非静态内部类，由于其本身就是一个非静态的上下文环境，
 *      因此非静态内部类不允许拥有静态成员。
 *      3.由于非静态内部类必须寄生在外部类的实例之中，程序创建非静态内部类对象的实例，
 *      派生非静态内部类的子类时都必须注意，只有在外部类的内部派生子类时安全的
 *      ---- 如果条件允许，推荐使用静态内部类，而不是非静态内部类。
 *          对于静态内部类来说，外部类相当于它的一个包，因此用法简单，限制也少。
 *              ---- 限制，静态内部类不能访问外部类的非静态成员。
 * static
 *  static用于修饰在类里定义的成员：Field、方法、内部类、初始化块、内部枚举类。
 *  static的作用就是把类里定义的成员变成静态成员，即类成员。
 *
 * native
 *
 * throwable ：
 *  安全的资源关闭方式，需保证三点：
 *      1.使用finally块来关闭物理资源，保证关闭操作总是会被执行
 *      2.关闭每个资源之前首先保证引用该资源的引用变量不为null
 *      3.为每个物理资源使用单独的try...catch块来关闭资源，
 *          保证关闭资源时引发的异常不会影响其它资源的关闭。
 *
 * @Author nya
 * @Date 2019/11/12 上午11:33
 **/
public class InnerTest {

    public static void main(String[] args) {
        /**
         * Unit 1
         */
        Wolf wolf = new Wolf("灰太狼");
        System.out.println("对象创建完成～～");
        Wolf grey = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("a.bin"));
            ois = new ObjectInputStream(new FileInputStream("a.bin"));
            oos.writeObject(wolf);
            oos.flush();
            grey = (Wolf) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(wolf);
        System.out.println(grey);

        System.out.println("-----------------------------");

        /**
         * Unit 2
         * 使用Java7增强的try语句关闭资源
         *  Java7新增了自动关闭资源的try语句：
         *      允许在try关键字后紧跟一对圆括号，圆括号可以声明、初始化一个或多个资源，
         *      此处的资源指的是那些必须在程序结束时显式关闭的资源，
         *      try语句会在该语句结束时自动关闭这些资源
         *  注意：
         *      为了保证try语句可以正常关闭资源，需要资源实现类
         *      实现AutoCloseable或Closeable接口，
         *      并实现其中的close()方法
         */
        Wolf w = new Wolf("小灰灰");
        System.out.println("对象创建完成～～～");
        Wolf w2 = null;
        try (
                ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("b.bin"));
                ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("b.bin"));
                ) {
            oos1.writeObject(w);
            oos1.flush();
            w2 = (Wolf) ois1.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(w);
        System.out.println(w2);

        System.out.println("-------------------");
        System.out.println(test());
        System.out.println(testFinally());

        System.out.println("--------------------");

        /**
         * Unit3 catch
         *  IndexOutOfBoundsException
         *  NullPointerException
         *  IOException
         *  ClassNotFoundException
         *  Exception - RuntimeException - UnChecked
         *              not RuntimeException - Checked
         *  Throwable
         */
        test1();
        test2();

    }

    public static int test() {
        int count = 0;
        try {
            return count++;
        } finally {
            System.out.println("finally 被执行了");
            return ++count;
        }
    }

    public static int testFinally(){
        int count = 5;
        try {
            System.out.println(5/0);
        } finally {
            System.out.println("finally testFinally 被执行了");
            return count;
        }
    }

    static void test1(){
        try (FileInputStream fis = new FileInputStream("abc.bin");)
        {
            System.out.println("file test RuntimeException");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void test2(){
        try {
            Class.forName("com.flow.Go");
            System.out.println("class forName");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
