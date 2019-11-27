package com.rosetta.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock : tryLock() 获取锁成功/失败校验demo
 *
 * Lock :
 *      void lock();
 *      void lockInterrupt
 */
public class ProblemTest1 {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService exec = Executors.newFixedThreadPool(5);
        List<Callable<Boolean>> callables = new ArrayList<>();
        Callable<Boolean> callable;
        for (int i = 0 ; i < 100 ; i++) {
            final int val = i;
            callable = () -> {
                ProblemTest1 problemTest1 = new ProblemTest1();
                boolean test = problemTest1.test(val);
                return test;
            };
            callables.add(callable);
        }
        List<Future<Boolean>> futures = exec.invokeAll(callables);
        for (Future<Boolean> each :
                futures) {
            System.out.println(each.get());
        }
        exec.shutdown();

    }
    boolean test(int i) throws InterruptedException {
        try {
            lock.lock();
//            TimeUnit.SECONDS.sleep(1);
            TimeUnit.MILLISECONDS.sleep(50);
            System.out.println(i  + " --- 获取锁成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return true;
//        boolean b = lock.tryLock(1,TimeUnit.SECONDS);
//        if (b) {
//            try {
//
//                TimeUnit.SECONDS.sleep(1);
//                System.out.println(i  + " --- 获取锁成功");
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//            }
//        } else {
//            System.out.println(i + " --- 获取锁失败");
//        }
//        return b;
    }
}
