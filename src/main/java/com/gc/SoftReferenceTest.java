package com.gc;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 对象软引用测试实例
 *
 * 内存充足时，软引用的对象可以正常使用；
 * 修改堆内存大小 -Xmx2m -Xms2m
 * 内存不足时，软引用的对象将被GC回收
 */
public class SoftReferenceTest {

    public static void main(String[] args) throws Exception {
        SoftReference<Person>[] people = new SoftReference[10000];
        for (int i = 0 ; i < people.length;i++){
            people[i] = new SoftReference<Person>(
                    new Person("name-" + i,(i+1)*4%100));
        }
        System.out.println(people[2].get());
        System.out.println(people[4].get());
        // 通知系统进行垃圾回收
        System.gc();
        System.runFinalization();

        System.out.println(people[2].get());
        System.out.println(people[4].get());

        System.out.println("====================================");

        // 对比强引用
        Person[] persons = new Person[10000];
        for (int i = 0 ; i < persons.length;i++) {
            persons[i] = new Person("name-" + i,(i+1)*4%100);
        }
        System.out.println(persons[2]);
        System.out.println(persons[4]);
        // 通知系统进行垃圾回收
        System.gc();
        System.runFinalization();

        System.out.println(persons[2]);
        System.out.println(persons[4]);

        System.out.println("====================================");

        // 对比弱引用
        WeakReference<Person>[] weakPersons = new WeakReference[10000];
        for (int i = 0 ; i < weakPersons.length;i++){
            weakPersons[i] = new WeakReference<>(
                    new Person("name-" + i,(i+1)*4%100));
        }
        System.out.println(weakPersons[2].get());
        System.out.println(weakPersons[4].get());
        // 通知系统进行垃圾回收
        System.gc();
        System.runFinalization();

        System.out.println(weakPersons[2].get());
        System.out.println(weakPersons[4].get());
    }

}

class Person {
    String name;
    int age;
    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
