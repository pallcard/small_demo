package cn.wishhust.concurrent.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        // 若将3改为4，程序会一直等待，没有4个线程到达屏障
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

        // 若将3改为4，程序会一直等待，没有4个线程到达屏障, 优先执行当任务也不会执行
        CyclicBarrier cyclicBarrier2 = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("优先执行");
            }
        });

        Thread thread1 = new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                System.out.println("到达屏障前");
            }
            try {
                cyclicBarrier.await();
                cyclicBarrier2.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("执行1");
        });

        Thread thread2 = new Thread(() -> {
            try {
                cyclicBarrier.await();
                cyclicBarrier2.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("执行2");
        });

        thread1.start();
        thread2.start();

        try {
            cyclicBarrier.await();
            cyclicBarrier2.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(1000);

        System.out.println("主线程");
    }
}
