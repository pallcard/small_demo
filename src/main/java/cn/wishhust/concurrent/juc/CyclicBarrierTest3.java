package cn.wishhust.concurrent.juc;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest3 {
    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        while (true) {

            Thread thread1 = new Thread(() -> {
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("执行1");
            });


            thread1.start();

            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                System.out.println(cyclicBarrier.isBroken());
                e.printStackTrace();
            }
            Thread.sleep(1000);

            System.out.println("主线程");

            cyclicBarrier.reset();

        }


    }
}
