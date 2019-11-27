package com.flow;

/**
 * Switch 流控制语句：
 *  switch语句的表达式只能是如下六种数据类型：
 *      byte：字节整型
 *      short：短整型
 *      int：整型
 *      char：字符型
 *      enum：枚举
 *      String类型
 *  但不能是long、float、double等其他基本类型
 */
public class EnumSwitchTest {
    public static void main(String[] args) {
        Season s = Season.FALL;
        switch (s) {
            case SPRING:
                System.out.println("一年之计在于春");
                break;
            case SUMMER:
                System.out.println("夏木阴阴正可人");
                break;
            case FALL:
                System.out.println("却道天凉好个秋");
                break;
            case WINTER:
                System.out.println("寒冬十二月，晨起践严霜");
                break;
            default:
                System.out.println("error");
                break;
        }
    }
}

enum Season {
    SPRING,SUMMER,FALL,WINTER
}
