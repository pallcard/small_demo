package cn.wishhust.concurrent.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


/**
 *
 * new CountDownLatch(N), 后面调用countDownLatch.await() 就会阻塞当前线程直到计数器<=0时，，调用countDownLatch.countDown()会使得计算器减1。
 *
 */


public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread thread1 = new Thread(() -> {
            System.out.println("执行1");
            countDownLatch.countDown();
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("执行2");
            countDownLatch.countDown();
            for(int i = 0; i < 1000; i++) {
                System.out.println("等待"+ (i+1));
            }
//            countDownLatch.countDown();
        });
        thread1.start();
        thread2.start();

        countDownLatch.await();

        System.out.println("主线程");
    }
}
