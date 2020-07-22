package com.object.leetcode.t1114;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kai.peng
 */
public class Solution1114_2 {
    private volatile int i = 0;

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        i++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (i!=1){};
        printSecond.run();
        i++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (i!=2){};
        printThird.run();
    }

    public static void main(String[] args) {
        int num = 0;
        num = (num + 1) % 3;

        System.out.println(num);
    }
}
