package main.java.cn.wishhust.apply;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class ThreadExcutor {

    private volatile boolean RUNNING = true;

    private static BlockingQueue<Runnable> queue = null;

    private final Set<Worker> workers = new HashSet<>();

    private final List<Thread> threadList = new ArrayList<>();

    int poolSize = 0;

    int coreSize = 0;

    boolean shutdown = false;

    public ThreadExcutor(int poolSize) {
        this.poolSize = poolSize;
        queue = new LinkedBlockingDeque<>(poolSize);
    }

    public void execute(Runnable runnable) {
        if (null == runnable) {
            throw new NullPointerException();
        }
        if (coreSize < poolSize) {
            addThread(runnable);
        } else {
            try {
                queue.put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addThread(Runnable runnable) {
        coreSize++;
        Worker worker = new Worker(runnable);
        workers.add(worker);
        Thread t = new Thread(worker);
        threadList.add(t);
        t.start();
    }

    public void shutdown() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RUNNING = false;
        if (!workers.isEmpty()) {
            for (Worker worker : workers) {
                worker.interruptIfIdle();
            }
        }
        shutdown = true;
        Thread.currentThread().interrupt();
    }

    class Worker implements Runnable {

        public Worker(Runnable runnable) {
            // 入队
            queue.offer(runnable);
        }

        @Override
        public void run() {
            while (RUNNING) {
                if (shutdown) {
                    Thread.interrupted();
                }
                while (!queue.isEmpty()) {
                    Runnable task = null;
                    try {
                        task = getTask();
                        // run的理解
                        task.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        public Runnable getTask() throws InterruptedException {
            return queue.take();
        }

        public void interruptIfIdle() {
            for (Thread thread : threadList) {
                System.out.println(thread.getName() + "interrupt");
                thread.interrupt();
            }
        }
    }


    // 测试
    public static void main(String[] args) {
        ThreadExcutor excutor = new ThreadExcutor(3);
        for (int i = 0; i < 10; i++) {
            excutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread: " + Thread.currentThread().getName() + " working...");
                }
            });
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        excutor.shutdown();


//        Executors.newCachedThreadPool()
        ThreadPoolExecutor ex = new ThreadPoolExecutor(3, 3, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 10; i++) {
            ex.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread: " + Thread.currentThread().getName() + " working...");
                }
            });
        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        ex.shutdown();


    }

}
