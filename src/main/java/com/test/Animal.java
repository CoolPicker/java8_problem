package com.test;

public interface Animal {

    void speak();

    default String category(String name) {
        System.out.print("I am ");
        System.out.println(name);
        return name;
    }

    default String eat(String food) {
        System.out.println("I am hungry!");
        System.out.println(food);
        return food;
    }

}
