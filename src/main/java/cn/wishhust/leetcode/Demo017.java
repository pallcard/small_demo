package cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 深度优先遍历
 */
public class Demo017 {

    public static String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv","wxyz"};

    public static List<String> list = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        StringBuilder sb = new StringBuilder();
        if (digits.equals("")  || digits == null) {
            return list;
        }
        letterCombinations(digits, sb, 0);
        return list;
    }

    public static void letterCombinations(String digits, StringBuilder sb, int k) {
        if (k == digits.length()) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < map[digits.charAt(k)-'0'].length(); i++) {
            sb.append(map[digits.charAt(k)-'0'].charAt(i));
            letterCombinations(digits, sb, k+1);
            sb.deleteCharAt(k);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));

    }

}
