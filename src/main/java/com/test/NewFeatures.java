package com.test;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @Description Java8新特性一览
 *  1. lambda表达式与函数式编程     对应 @FunctionalInterface 注解
 *          函数的default实现和静态方法不会破坏@FunctionalInterface的功能性
 *      常见示例 java.lang.Runnable java.util.concurrent.Callable
 *  2. 接口的默认静态方法
 *      相较于abstract方法,default方法不需要实现,且将被继承
 *  3. 方法引用
 *      Supplier类   Class<T>::new  Class::new
 *      Class::static_method 注意指定唯一参数 该对象的引用变量
 *  4. 重复注解
 *      RepeatingAnnotations.class
 *
 *
 * @Author nya
 * @Date 2020/4/2 下午3:49
 **/
public class NewFeatures {

    public static void main(String[] args) {


        Arrays.asList("me","her","them").forEach(System.out::println);

        Arrays.asList(32,23,66,999).forEach(
                e -> {
                    String jack = e + "-1000";
                    System.out.println(jack);
                });

        Arrays.asList("a","b","c","d").sort(String::compareTo);
        List<String> arr = Arrays.asList("m", "j", "a", "z", "n");
        arr.sort(String::compareTo);
        System.out.println(arr);

        // 测试接口默认方法特性
        Defaultable defaultable1 = new DefaultableImpl();
        Defaultable defaultable2 = new OverridableImpl();
        System.out.println(defaultable1.notRequired());
        System.out.println(defaultable2.notRequired());

        // 测试接口自带的默认方法
        Defaultable defaultable = DefaultableFactory.create(DefaultableImpl::new);
        System.out.println(defaultable.notRequired());
        defaultable = DefaultableFactory.create(OverridableImpl::new);
        System.out.println(defaultable.notRequired());


        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);

        cars.forEach(Car::collide);
        cars.forEach(Car::repair);

        final Car police = Car.create( Car::new );
        cars.forEach( police::follow );

        // # 与 0 的区别, # 没有则为空, 0 没有则补零
        DecimalFormat df = new DecimalFormat("#.##");
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String format = df.format(3.456789);
        String format1 = decimalFormat.format(3.456789);
        System.out.println(format);
        System.out.println(format1);
    }

    private interface Defaultable {
        default String notRequired(){
            return "Default implementation";
        }
    }

    private static class DefaultableImpl implements Defaultable {}

    private static class OverridableImpl implements Defaultable {

        @Override
        public String notRequired() {
            return "Overridden implementation";
        }
    }

    private interface DefaultableFactory {
        static Defaultable create(Supplier<Defaultable> supplier) {
            return supplier.get();
        }
    }

    private static class Car {

        public static Car create(final Supplier<Car> supplier) {
            return supplier.get();
        }

        public static void collide(final Car car) {
            System.out.println("Collided " + car.toString());
        }

        public void follow(final Car another) {
            System.out.println("Following the " + another.toString());
        }

        public void repair(){
            System.out.println("Repaired " + this.toString());
        }
    }
}
