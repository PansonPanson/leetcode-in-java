package top.panson.injava.question.practice.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * 1115. 交替打印 FooBar
 *
 * @create 2022-02-28 23:06
 * @Author: Panson
 */
public class L1115 {
    class FooBar {
        private int n;

        private Semaphore semaphoreFoo;
        private Semaphore semaphoreBar;

        public FooBar(int n) {
            this.n = n;
            semaphoreFoo = new Semaphore(1);
            semaphoreBar = new Semaphore(0);
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                semaphoreFoo.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                semaphoreBar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                semaphoreBar.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                semaphoreFoo.release();
            }
        }
    }
}
