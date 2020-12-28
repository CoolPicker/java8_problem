package com.test;

/**
 * @Description TODO
 * @Author nya
 * @Date 2020/7/21 下午3:29
 **/
public class TestFunctionInterfaceTest {

    public static void main(String[] args) {
        test(() -> {
            System.out.println("aaa");
        });
    }

    static void test(TestFunctionalInterface tfi) {
        tfi.test();
    }
}
