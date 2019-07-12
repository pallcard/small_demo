package main.java.cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo241 {

    public static List<Integer> list = new ArrayList<>();
    public static List<Integer> diffWaysToCompute(String input) {
        final String[] str = input.split("[+ - *]");
        int [] nums = new int [str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(nums[i]);
        }

        compute(input, str);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        return list;
    }

    public static void compute(String input, String[] str) {

        if (input.length() == 3) {
            int result = handle(str[0]-'0',input.charAt(2)-'0',input.charAt(1));
            list.add(result);
            return;
        }

        StringBuilder sb = new StringBuilder(input);
        // 符号个数
        int n = (input.length()-1)/2;
        for (int i = 0; i < n; i++) {
            int t = handle(input.charAt(i*2)-'0', input.charAt(i*2+2)-'0', input.charAt(i*2+1));
            sb.delete(i*2,i*2+3).insert(i*2,t);
            compute(sb.toString());
            sb = new StringBuilder(input);
        }
    }


    public static int handle(int a, int b, char operator) {
        if (operator == '+') {
            return a+b;
        } else if (operator == '-') {
            return a-b;
        } else {
            return a*b;
        }
    }

    public static void main(String[] args) {
        diffWaysToCompute("15-7*6+24");
    }
}
