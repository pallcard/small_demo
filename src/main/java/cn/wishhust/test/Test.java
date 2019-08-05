package cn.wishhust.test;

import java.net.SocketTimeoutException;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
//        String str = "<h1>test</h1>";
//        boolean result = str.matches("<(h[1-6])>\\w*?<\\/\\1>");
//        System.out.println(result);
//        str = "a";
//        switch (str) {
//            case "a":
//                System.out.println("a");
//                break;
//            case "b":
//                System.out.println("b");
//                break;
//        }

//        Integer i = 128;
//        Integer j = 128;
//        System.out.println(i==j);
//        int [] a = new int [10];
//        for (int t : a) {
//            System.out.print(t+" ");
//        }
//        System.out.println("a b a");
//        TreeMap

        int n = fun2(fun1(101)) % 4;
        System.out.println(1);
        System.out.println(n);
    }


    public static int fun1(int i) {
        return i <= 1 ? 1: fun1(i-1)+fun1(i-3);
    }

    public static int fun2(int i) {
        return ((i>>8) & 0x64) & (((i << 8) & 0x9346)>>8);
    }
}
