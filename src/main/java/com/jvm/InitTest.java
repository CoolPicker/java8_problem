package com.jvm;

/**
 * 涉及父类的类初始化时，构造器与非静态代码块加载顺序测试
 */
public class InitTest {
    public static void main(String[] args) {
        new Wolf(3.3);
    }
}


class Wolf extends Animal{
    {
        System.out.println("Wolf non-static code blocks");
    }
    public Wolf(){
        super("灰太狼",3);
        System.out.println("Wolf without arguments constructor");
    }
    public Wolf(double weight) {
        this();
        System.out.println("Wolf with weight argument constructor + " + weight);
    }
}

class Animal extends Creature {
    {
        System.out.println("Animal non-static code blocks");
    }
    public Animal(){
        System.out.println("Animal without arguments constructor");
    }
    public Animal(String name) {
        super(name);
        System.out.println("Animal with name argument constructor + " + name);
    }
    public Animal(String name,int age) {
        this(name);
        System.out.println("Animal with name & age arguments constructor + " + age);
    }
}

class Creature{
    {
        System.out.println("Creature non-static code blocks");
    }
    public Creature(){
        System.out.println("Creature without arguments constructor");
    }

    public Creature(String name) {
        this();
        System.out.println("Creature with name argument constructor + " + name);
    }
}
