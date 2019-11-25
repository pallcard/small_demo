package cn.wishhust.concurrent.juc;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {

    private static final Exchanger<String> exgr = new Exchanger<>();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        threadPool.execute(()->{
            String A = "流水A";
            try {
                String B = exgr.exchange(A + Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName()+A.equals(B)+ " A: " + A + " B: " + B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.execute(()->{
            String B = "流水B";
            try {
                String A = exgr.exchange(B+ Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName()+A.equals(B)+ " A: " + A + " B: " + B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.shutdown();
    }
}
