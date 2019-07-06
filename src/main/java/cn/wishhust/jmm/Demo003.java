package main.java.cn.wishhust.jmm;

import java.util.HashSet;
import java.util.Set;

public class Demo003 {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            a = 0; b= 0; x = 0; y = 0;
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                }
            });

            Thread other = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            });
            one.start();
            other.start();
            one.join();
            other.join();
            result.add("(" + x + "," + y + ")");
//            if (x == 0 && y == 0) {
                System.out.println(result.toString());
//            }
        }
    }
}
