package main.java.cn.wishhust.test;

import java.net.SocketTimeoutException;

public class Test {
    public static void main(String[] args) {
        String str = "<h1>test</h1>";
        boolean result = str.matches("<(h[1-6])>\\w*?<\\/\\1>");
        System.out.println(result);
        str = "a";
        switch (str) {
            case "a":
                System.out.println("a");
                break;
            case "b":
                System.out.println("b");
                break;
        }
    }
}
