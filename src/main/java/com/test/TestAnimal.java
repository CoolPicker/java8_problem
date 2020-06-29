package com.test;

/**
 * @Description TODO
 * @Author nya
 * @Date 2020/4/7 下午5:04
 **/
public class TestAnimal {

    static class Cat implements Animal {

        @Override
        public void speak() {
            System.out.println("喵喵喵~");
        }
    }

    static class Dog implements Animal {
        @Override
        public void speak() {
            System.out.println("汪汪汪~");
        }
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        cat.speak();
        dog.speak();
        cat.eat("fish");
        dog.eat("bone");
        cat.category("mimi");
        dog.category("hei");



    }

}
