package com.jvm;

/**
 * 类变量的初始化时机
 * 初始化分为两个阶段：
 *  为类变量分配内存空间，并给定默认值
 *  按顺序依次为类变量赋值
 *
 *  当创建任何Java对象时，程序总会先依次调用每个父类的非静态初始化块、构造器（总是从Object开始）执行初始化，
 *  然后才调用本类的非静态初始化块、构造器执行初始化。
 */
public class PriceTest {
    public static void main(String[] args) {
        Price p = new Price(2.8);
        System.out.println(Price.INSTANCE.currentPrice); // -2.8
        System.out.println(p.currentPrice); // 17.2
    }
}
class Price{
    final static Price INSTANCE = new Price(2.8);
    // final修饰变量，，如果定义时就指定初始值，且该初始值在编译时就确定下来，
    // 那么这个final变量将不再是一个变量，系统会将其当成“宏变量”处理。--- 常量
    // 即，所有出现该变量的地方，系统将直接把它当成对应的值处理
    // final static double initPrice = 20;
    static double initPrice = 20;
    double currentPrice;

    public Price(double discount) {
        currentPrice = initPrice - discount;
    }
}
