package cn.wishhust.jmm;

import java.util.ArrayList;

public class JConsoleTest {

    public byte [] b1 = new byte[1024*128];

    public static void main(String[] args) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("start ...");
        fill(1000);
    }

    private static void fill(int n) {
        ArrayList<Object> jlist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            jlist.add(new JConsoleTest());
        }
    }
}
