package com.object.leetcode.t1116;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * https://leetcode-cn.com/problems/print-zero-even-odd/
 *
 * @author kai.peng
 */
public class ZeroEvenOdd {
    private int n;
    private ReentrantLock lock = new ReentrantLock();
    private Condition zoreCondition = lock.newCondition();
    private Condition evenCondition = lock.newCondition();
    private Condition oddCondition = lock.newCondition();
    private boolean printOtherFlag = true;
    private int index = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            for (int i = 1; i <= n; i++) {
                while (!printOtherFlag) {
                    System.out.println("zero-await");
                    zoreCondition.await();
                    System.out.println("zero-signal");
                }
                printNumber.accept(0);
                index = i;
                printOtherFlag = false;
                if (i % 2 != 0) {
                    System.out.println("odd-signal");
                    oddCondition.signal();
                } else {
                    System.out.println("even-signal");
                    evenCondition.signal();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            for (int i = 2; i <= n; i += 2) {
                while (printOtherFlag || index != i) {
                    System.out.println("even-await-1");
                    evenCondition.await();
                    System.out.println("even-signal-1");
                }
                printNumber.accept(i);
                printOtherFlag = true;
                zoreCondition.signal();
                System.out.println("even-zore-signal");
            }
        } finally {
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            for (int i = 1; i <= n; i += 2) {
                while (printOtherFlag || index != i) {
                    System.out.println("odd-await-1");
                    oddCondition.await();
                    System.out.println("odd-signal-1");
                }
                printNumber.accept(i);
                printOtherFlag = true;
                zoreCondition.signal();
                System.out.println("odd-zore-signal");
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd zeo = new ZeroEvenOdd(4);

        Thread threadA = new Thread(() -> {
            try {
                zeo.zero(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                zeo.even(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                zeo.odd(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadA.setName("zero");
        threadA.start();
        Thread.sleep(100);
        threadB.setName("even");
        Thread.sleep(100);
        threadB.start();
        threadC.setName("odd");
        Thread.sleep(200);
        threadC.start();


    }


}
