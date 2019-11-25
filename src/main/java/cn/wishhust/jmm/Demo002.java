package cn.wishhust.jmm;

public class Demo002 {

    //volatile 不能解决原子性问题
    public static volatile int num = 0;

    public static void increase() {
        num++; // 非原子操作
    }

    public static void main(String[] args) throws InterruptedException {
        final Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        for(Thread t : threads) {
            t.join();
        }
        System.out.println(num);
    }
}
