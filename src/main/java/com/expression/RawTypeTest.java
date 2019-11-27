package com.expression;

/**
 * java是一门强类型语言，不仅每个变量具有指定的数据类型，它的表达式也具有指定的数据类型。
 *
 * 强类型语言，两个基本特征：
 *  1.所有的变量必须先声明，然后才能使用，声明变量时必须指定该变量的数据类型
 *  2.一旦某个变量的数据类型确定下来，那么这个变量将永远只能接受该类型的值。
 *
 *  Java 5新增了泛型，允许在使用Java类、调用方法时传入一个类型实参，
 *  这样就可以让Java类、调用方法动态地改变类型。
 *
 */
public class RawTypeTest {

    public static void main(String[] args) {
        Apple<Integer> apple = new Apple<>(6);
        Integer size = apple.getSize();
        Apple b = apple;
        Number size1 = b.getSize();
        Number size2 = b.getSize();
        System.out.println(size);
        System.out.println(size1);
        System.out.println(size2);

        String clazz = "java.lang.String.hashCode.121";
        // replace() 参数是普通字符串
        String path1 = clazz.replace(".", "\\");
        System.out.println(path1);
        // replaceAll() 参数是正则表达式
        String path2 = clazz.replaceAll("\\.", "\\\\");
        System.out.println(path2);
    }

}

class Apple<T extends Number> {
    T size;
    public Apple(){}
    public Apple(T size) {
        this.size = size;
    }

    public T getSize() {
        return size;
    }

    public void setSize(T size) {
        this.size = size;
    }
}
