package com.jvm;

/**
 * Java的内存管理分为两个方面:内存分配和内存回收
 * 肆无忌惮地创建对象,坏处:
 *  1.不断分配内存使得系统中可用的内存减少,从而降低程序的运行性能
 *  2.大量已分配内存的回收使得垃圾回收的负担加重,降低程序的运行性能
 *
 * Java程序中的变量分为成员变量和局部变量.
 *  其中局部变量分为三类:形参/方法内的局部变量/代码块内的局部变量
 * 局部变量作用时间短,被存储在栈内存中.
 *
 * 使用static修饰的成员变量是类变量,属于该类本身;
 * 没有使用static修饰的成员变量是实例变量,属于该类的实例.
 * 在同一个JVM内,每个类只对应一个Class对象,但每个类可以创建多个Java对象.
 * 故而类变量只需一块内存空间;实例变量的话,该类没创建一次实例,就需要为实例变量分配一块内存空间.
 *
 * 每个类初始化完成之后,系统都会为该类创建一个对应的Class实例,程序可以通过反射来获取某个类对应的Class实例.
 *
 * 从语法角度来看,程序可以再三个地方对实例变量执行初始化:
 *  1.定义实例变量时指定初始值
 *  2.非静态初始化块中对实例变量指定初始值
 *  3.构造器中对实例变量指定初始值
 *
 *
 */
public class MemoryManagementTest {

    int mm = 99;
    int nn = mm + jj;
    static int jj = 15;

    {
        int a = 11;
        int b = 22;
        System.out.println(a+b);
    }

    void test(){
        System.out.println(mm);
        System.out.println(nn);
    }


    public static void main(String[] args) {
        Person p = new Person();
        Person.keys = 12;
        Person.keys = 99;
        p.keys = 111; // 底层仍然会通过Person类对象访问类变量keys 等同于 Person.keys
        System.out.println(p.keys);
        System.out.println(Person.keys);
        p.name = "曹操";
        p.age = 999;
        p.say();
    }



}

class Person{
    String name;
    int age;
    static int keys;

    void say(){
        System.out.println("name : " + name + " age : " + age);
    }

}
