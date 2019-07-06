package main.java.cn.wishhust.test;

public class Test {
    public static void main(String[] args) {
        String str = "<h1>test</h1>";
        boolean result = str.matches("<(h[1-6])>\\w*?<\\/\\1>");
        System.out.println(result);
    }
}
