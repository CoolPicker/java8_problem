package com.jvm;

import java.util.Arrays;

/**
 * 测试匿名内部类中对于外部变量的使用
 * 如果程序需要在匿名内部类中使用局部变量，那么这个局部变量个必须使用final修饰符修饰。
 * why？
 * 对于普通的局部变量而言，它的作用域就停留在该方法内，
 * 当方法执行结束后，该局部变量也随之消失；
 * 但内部类则可能产生隐式的“闭包-Closure”，闭包将使得局部变量脱离它所在的方法继续存在。
 * 由于内部类可能扩大局部变量的作用域，如果被内部类访问的局部变量没有使用final修饰，
 * 即该变量的值可以随意改变，将引起混乱，故而Java编译器要求内部类访问的局部变量必须使用final修饰。
 */
public class TestFinalVariableAtAnonymousInnerClass {

    public int[] process(IntArrayProductor cmd, int length) {
        int[] result = new int[length];
        for (int i = 0 ; i < length;i++){
            result[i] = cmd.product();
        }
        return result;
    }

    public static void main(String[] args) {
        TestFinalVariableAtAnonymousInnerClass test = new TestFinalVariableAtAnonymousInnerClass();
        final int seed = 5;
        int[] result = test.process(new IntArrayProductor() {
            @Override
            public int product() {
                return (int)Math.round(Math.random()*seed);
            }
        },6);
        System.out.println(Arrays.toString(result));
    }

}

interface IntArrayProductor{
    int product();
}
