package com.test;

/**
 * @Description
 * @Author nya
 * @Date 2020/7/27 上午11:09
 **/
public class ThreadDeadLockDemo {

    public static void main(String[] args) {

        final Object objOne = new Object();
        final Object objTwo = new Object();

        Thread first = new Thread("first"){
            @Override
            public void run() {
                synchronized (objOne){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    synchronized (objTwo){
                        System.out.println("first thread done");
                    }

                }
            }
        };

        Thread second = new Thread("second"){
            @Override
            public void run() {
                synchronized (objTwo){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    synchronized (objOne){
                        System.out.println("second thread done");
                    }
                }
            }
        };
        first.start();
        second.start();
    }

}
