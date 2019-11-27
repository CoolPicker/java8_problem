package com.jvm;

/**
 * 当this在构造器中时，this代表正在初始化的Java对象。
 *
 * 当变量的编译时类型和运行时类型不同时，
 * 通过该变量访问它引用的对象的实例变量时，该实例变量的值由声明该变量的类型决定。
 * 但通过该变量调用它引用的对象的实例方法时，该方法行为将由它实际所引用的对象来决定。
 * 因此，当程序访问this.i时，将会访问Base类中定义的实例变量i，即输出2；
 * 但执行this.display();代码时，则实际表现为Derived对象的行为，输出Derived对象的实例变量i，即0
 *
 * 注意：当变量的编译时类型和运行时类型不同时，
 * 系统在调用它的实例变量和实例方法时存在差异。
 */
public class TestAccessDerived {
    public static void main(String[] args) {
        Derived derived = new Derived();
//        derived.display();
    }
}

class Derived extends Base {
    private int i = 22;
    public Derived() {
        i = 222;
    }
    public void display(){
        System.out.println(i);
    }

    public void sub(){
        System.out.println("haha");
    }

}

class Base {
    private int i = 2;
    public Base(){
        System.out.println(this.i);
        this.display();
        System.out.println(this.getClass());
        //this.sub(); 编译时类型为Base，运行时类型Derived
    }
    public void display(){
        System.out.println(i);
    }
}