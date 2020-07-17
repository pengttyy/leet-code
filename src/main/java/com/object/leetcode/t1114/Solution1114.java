package com.object.leetcode.t1114;

import java.util.concurrent.CountDownLatch;

/**
 * @author kai.peng
 */
public class Solution1114 {
    private CountDownLatch firstSecond = new CountDownLatch(1);
    private CountDownLatch secondThird = new CountDownLatch(1);


    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstSecond.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstSecond.await();
        printSecond.run();
        secondThird.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondThird.await();
        printThird.run();
    }

    public static void main(String[] args) {
        int num = 0;
        num = (num + 1) % 3;

        System.out.println(num);
    }
}
