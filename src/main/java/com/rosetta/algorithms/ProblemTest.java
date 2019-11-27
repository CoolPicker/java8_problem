package com.rosetta.algorithms;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public class ProblemTest {

    public static void main(String[] args) {

        System.out.println(test());
        // 浮点类型计算, 偏移量
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b);
        System.out.println("-----------------------------------");
        BigDecimal b1 = new BigDecimal(1.0f);
        BigDecimal b2 = new BigDecimal(0.9f);
        BigDecimal b3 = new BigDecimal(0.8f);
        BigDecimal c = b1.subtract(b2);
        System.out.println(c.floatValue());
        BigDecimal d = b2.subtract(b3);
        System.out.println(d.floatValue());
        System.out.println(c.equals(d));
        System.out.println("-----------------------------------");
        Float m = Float.valueOf(1.0f - 0.9f);
        Float n = Float.valueOf(0.9f - 0.8f);
        System.out.println(m);
        System.out.println(n);
        System.out.println(m.equals(n));
        System.out.println("-----------------------------------");
//        String param = null;
//        switch (param) {
//            case "null":
//                System.out.println("null");
//                break;
//            default:
//                System.out.println("default");
//        }
//        System.out.println("-----------------------------------");
        BigDecimal x = new BigDecimal(0.1f);
        BigDecimal y = new BigDecimal(0.1f);
        System.out.println(x.equals(y));
        System.out.println(x);
        System.out.println(y);




    }

    static Integer test(){
        System.out.println("begin ------");
        try {
            int a = 99;
            System.out.println("a before ----");
//            System.out.println(1/0);
            if (a == 99) {
                return 3;
            }
            System.out.println("a after ----");

        } catch (Exception e) {
            System.out.println("catch .....");
            return 2;
        } finally {
            System.out.println("finally");
        }
        return 1;
    }

}
