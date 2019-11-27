package com.jvm;

/**
 * 继承过程中成员变量与方法的区别
 *
 *  ×××
 *  如果子类重写了父类方法，就意味着子类里定义的方法彻底覆盖了父类里的同名方法，
 *  系统将不可能把父类里的方法转移到子类中。
 *  对于实例变量则不存在这样的现象，即使子类中定义了父类完全同名的实例变量，
 *  这个实例变量也依然不可能覆盖父类中定义的实例变量。
 *
 *  因为继承成员变量和继承方法之间存在这样的差别，所以对于一个引用类型的变量而言，
 *  当通过该变量访问它所引用的对象的实例变量时，
 *  该实例变量的值取决于声明该变量时的类型；
 *  当通过该变量过来调用它所引用的对象的方法时，
 *  该方法行为取决于它所实际引用的对象的类型。
 *
 *  成员变量一般不会在类中直接赋值，多在实际调用中处理赋值问题。
 *
 *  参见 /data/test/latest/Wolf.java
 *      当子类使用public访问控制符修饰，而父类不适用public修饰符修饰时，
 *      才可以通过javap看到编译器将父类的public方法直接转移到子类中。
 */
public class TestFieldAndMethodExtends {
    public static void main(String[] args) {
        BaseOne b = new BaseOne();
        System.out.println(b.count);    // 1
        b.display();
        DerivedOne d = new DerivedOne();// 2
        System.out.println(d.count);
        d.display();
        BaseOne bd = new DerivedOne();  // 3
        System.out.println(bd.count);
        bd.display();
        BaseOne d2b = d;                // 4
        System.out.println(d2b.count);
    }
}

class DerivedOne extends BaseOne {
    int count = 20;

    @Override
    public void display() {
        System.out.println(this.count);
    }
}

class BaseOne {
    int count = 2;
    public void display(){
        System.out.println(this.count);
    }
}
