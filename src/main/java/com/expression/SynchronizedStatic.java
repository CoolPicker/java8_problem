package com.expression;

/**
 * 静态的同步方法
 */
public class SynchronizedStatic implements Runnable {

    static boolean staticFlag = true;

    public static synchronized void test0() {
        for (int i = 0 ; i < 10000; i++) {
            System.out.println("test0: " +
                    Thread.currentThread().getName() + " " + i);
        }
    }

    /**
     * 使用this，多线程条件下，其他线程可以获得对引用变量所引用对象的锁定，
     * 故而需要将同步代码块的同步监视器改为具体的类
     */
//    public void test1() {
//        synchronized (this) {
//            for (int i = 0 ; i < 10000 ; i++) {
//                System.out.println("test1: " +
//                        Thread.currentThread().getName() + " " + i);
//            }
//        }
//    }
    public void test1() {
        synchronized (SynchronizedStatic.class) {
            for (int i = 0 ; i < 10000 ; i++) {
                System.out.println("test1: " +
                        Thread.currentThread().getName() + " " + i);
            }
        }
    }

    @Override
    public void run() {
        if (staticFlag) {
            staticFlag = false;
            test0();
        } else {
            staticFlag = true;
            test1();
        }
    }

    public static void main(String[] args) throws Exception {
        SynchronizedStatic ss = new SynchronizedStatic();
        new Thread(ss).start();
        Thread.sleep(1);
        new Thread(ss).start();
    }

}
