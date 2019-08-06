package cn.wishhust.concurrent.juc;


/**
 * join 原理： 不停检查join线程是否存活，若join线程存活则让当前线程等待。
 *
 */


public class JoinCountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("执行1");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("执行2");
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("主线程");
    }
}
