package com.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 *  悲观锁/乐观锁
 *  线程要不要锁住同步资源:
 *      锁住 - 悲观锁
 *      不锁住 - 乐观锁 CAS compare and swap
 *
 *  公平锁/非公平锁
 *  其它等待中的线程是否按顺序获取锁:
 *      顺序 - 公平锁 - 等待的线程不会饿死, 但整体效率较低       new ReentrantLock(true)
 *      无序 - 非公平锁 - 整体效率相对较高, 但会出现饿死或者早来却很久之后才消费锁   new ReentrantLock(false)
 *
 * @Author nya
 * @Date 2020/8/25 下午2:34
 **/
public class PessimisticLockVsOptimisticLock {

    private int total = 10000;

    // 不加锁, 无法保证原子性
    public void downNothing(){
        total--;
    }

    // 悲观锁 synchronized
    public synchronized void downIterator() {
        total--;
    }
    // 悲观锁 ReentrantLock
    private ReentrantLock lock = new ReentrantLock(); // 默认非公平锁
//    private ReentrantLock lock = new ReentrantLock(true); // 公平锁
    public void downList(){
        lock.lock();
        total--;
        lock.unlock();
    }

    // 乐观锁
    // 需要保证多个线程使用同一个AtomicInteger
    private AtomicInteger atomicInteger = new AtomicInteger(10000);
    public void downOpt(){
        atomicInteger.decrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        PessimisticLockVsOptimisticLock po = new PessimisticLockVsOptimisticLock();
        long start = System.currentTimeMillis();
        CountDownLatch latch = new CountDownLatch(10000);

        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
//                po.downNothing(); // 不为零
//                po.downIterator(); // 为零
//                po.downList(); // 为零
                po.downOpt(); // CAS 为零
                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.println(po.total);
        System.out.println(po.atomicInteger.get());
        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms");

    }

}
