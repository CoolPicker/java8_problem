package com.test;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @Description TODO
 * @Author nya
 * @Date 2020/7/21 下午5:45
 **/
public class PredicateConsumerTest {
    int a = 9;

    public static void main(String[] args) {
        AtomicInteger studentNumber = new AtomicInteger(10000);

        Student mm = new Student("mm",500);
        Student pp = null;
        Student nn = Optional.ofNullable(mm).orElseGet(() -> new Student("test", 100));
        Student qq = Optional.ofNullable(pp).orElseGet(() -> new Student("test", 100));
        System.out.println(nn);
        System.out.println(qq);


//        Student one = new Student("Jack", 500);
//        generateAndUpdateFee(one,
//                student -> student.score > 480,
//                student -> student.score > 400 && student.score < 480,
//                student -> student.studentNumber = studentNumber.getAndIncrement(),
//                student -> student.feeDiscount = 100.0,
//                student -> student.feeDiscount = 50.0);
//        System.out.println(one);
//        Student two = new Student("Tom", 401);
//        generateAndUpdateFee(two,
//                student -> student.score > 480,
//                student -> student.score > 400 && student.score < 480,
//                student -> student.studentNumber = studentNumber.getAndIncrement(),
//                student -> student.feeDiscount = 100.0,
//                student -> student.feeDiscount = 50.0);
//        System.out.println(two);
    }

    /**
     * 生成学号
     * @param student
     * @param consumer
     * @return
     */
    static void generateStudentNumber(Student student, Consumer<Student> consumer) {
        consumer.accept(student);
    }

    /**
     * 生成学号并更新减免比例
     */
    static void generateAndUpdateFee(Student student,
                                        Predicate<Student> predicateOne,
                                        Predicate<Student> predicateTwo,
                                        Consumer<Student> consumerGenerate,
                                        Consumer<Student> consumerOne,
                                        Consumer<Student> consumerTwo){
        if (predicateOne.test(student)){
            Consumer<Student> one = consumerOne.andThen(consumerGenerate);
            one.accept(student);
        }
        if (predicateTwo.test(student)) {
            Consumer<Student> two = consumerTwo.andThen(consumerGenerate);
            two.accept(student);
        }
    }

    static class Student{
        String name; // 姓名
        Integer studentNumber = 0; // 学号
        Integer score;	// 分数
        Double feeDiscount = 0.0; // 减免比例
        Double baseFee = 5000.0; // 学费

        public Student(String name,Integer score){
            this.name = name;
            this.score = score;
        }

        public Double getFee(){
            return baseFee * (1 - (feeDiscount / 100));
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", studentNumber=" + studentNumber +
                    ", fee=" + baseFee * (1 - (feeDiscount / 100)) +
                    '}';
        }
    }

}
