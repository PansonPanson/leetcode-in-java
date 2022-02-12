package top.panson.injava.question.practice.concurrency;

import java.util.concurrent.Semaphore;

/**
 * 1114. 按序打印
 *
 * @create 2022-02-12 15:30
 * @Author: Panson
 */
public class L1114 {
    class Foo {

        private Semaphore semaphore12;
        private Semaphore semaphore23;


        public Foo() {
            semaphore12 = new Semaphore(0);
            semaphore23 = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            semaphore12.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            semaphore12.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            semaphore23.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            semaphore23.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
