package cn.wishhust.concurrent.juc;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest2 {
    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        Thread thread1 = new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("执行1");
        });


        thread1.start();
        thread1.interrupt();

        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            // 阻塞线程是否被中断。
            System.out.println(cyclicBarrier.isBroken());
            e.printStackTrace();
        }
        Thread.sleep(1000);

        System.out.println("主线程");
    }
}
