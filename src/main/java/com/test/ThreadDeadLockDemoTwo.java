package com.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Author nya
 * @Date 2020/7/27 上午11:29
 **/
public class ThreadDeadLockDemoTwo {

    public static void main(String[] args) {
        final ReentrantLock lockOne = new ReentrantLock();
        final ReentrantLock lockTwo = new ReentrantLock();

        new ThreadFirst(lockOne,lockTwo).start();
        new ThreadSecond(lockOne,lockTwo).start();
    }

    static class ThreadFirst extends Thread {
        private ReentrantLock lockOne;
        private ReentrantLock lockTwo;

        public ThreadFirst(ReentrantLock lockOne, ReentrantLock lockTwo) {
            this.lockOne = lockOne;
            this.lockTwo = lockTwo;
        }

        @Override
        public void run() {
            try {
                lockOne.lock();
                Thread.sleep(3000);
                // 必须获取两个锁后才执行后续操作
                lockTwo.lock();
                System.out.println("first start");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockTwo.unlock();
                lockOne.unlock();
            }
        }
    }

    static class ThreadSecond extends Thread {
        private ReentrantLock lockOne;
        private ReentrantLock lockTwo;

        public ThreadSecond(ReentrantLock lockOne, ReentrantLock lockTwo) {
            this.lockOne = lockOne;
            this.lockTwo = lockTwo;
        }

        @Override
        public void run() {
            try {
                lockTwo.lock();
                Thread.sleep(1000);
                lockOne.lock();
                System.out.println("second start");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockOne.unlock();
                lockTwo.unlock();
            }
        }
    }
}
