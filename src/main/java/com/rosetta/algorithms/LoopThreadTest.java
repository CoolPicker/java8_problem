package com.rosetta.algorithms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoopThreadTest {
    private static final Integer threadSize = 13;

    public static void main(String[] args) {
        ExecutorService exec = null;
        try {
            exec = Executors.newFixedThreadPool(threadSize);
            Runnable runnable = () -> {
                while (true) {
                    System.out.println("thread");
                }
            };

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
