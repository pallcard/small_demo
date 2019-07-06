package main.java.cn.wishhust.algorithm;

/**
 * 正则表达式匹配问题
 *
 *  . 一个任意字符
 *  * 表示*前字符出现（0-？）字符
 *  aaa
 *  ab*ac*a  a.a
 */

public class Demo016 {
    public static void main(String[] args) {
        String string = "aaa";
        String pattern = "ab*a";

        int index = 0;
        int i = 0;
        boolean result = true;

        for (i = 0; i < pattern.length(); i++) {
            if (index >= string.length()) {
                result = false;
                break;
            }
            if (pattern.charAt(i) == '.') {
                index++;
                continue;
            }
            if(pattern.charAt(i) == string.charAt(index)) {
                index++;

            } else if(pattern.charAt(i+1) != '*') {
                result = false;
                break;
            } else if (pattern.charAt(i+1) == '*') {
                i+=1;
            }
        }
        if(index != string.length() || i != pattern.length()) {
            result = false;
        }
        System.out.println(result);
    }
}
