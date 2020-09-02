package com.assess15.leetcode.multithreading;

/**
 * 用三个线程，顺序打印字母A-Z，输出结果是1A、2B、3C、1D 2E...
 */

public class ThreadConcurrentDemo {

    private static char c = 'A';
    private static int i = 0;

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        int threadId = Integer.parseInt(Thread.currentThread().getName());
                        while (i < 26) {
                            if (i % 3 == threadId - 1) {
                                System.out.println(threadId + "" + (char) c++);
                                i++;
                                notifyAll();
                            } else {
                                wait();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t1 = new Thread(runnable, "1");
        Thread t2 = new Thread(runnable, "2");
        Thread t3 = new Thread(runnable, "3");
        t1.start();
        t2.start();
        t3.start();
    }
}
