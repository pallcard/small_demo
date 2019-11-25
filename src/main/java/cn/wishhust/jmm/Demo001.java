package cn.wishhust.jmm;

public class Demo001 {
    private static boolean initFlag = false;
//    private static volatile boolean initFlag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("等待数据准备");
                while (!initFlag) {}
                System.out.println("数据准备完毕，执行程序逻辑");
            }
        }).start();

        Thread.sleep(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("数据准备中。。。");
                initFlag = true;
                System.out.println("数据准备完成");
            }
        }).start();
    }
}
