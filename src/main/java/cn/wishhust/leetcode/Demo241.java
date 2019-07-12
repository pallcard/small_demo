package main.java.cn.wishhust.leetcode;

import java.util.*;

public class Demo241 {

    public static List<Integer> list = new ArrayList<>();



    public static List<Integer> diffWaysToCompute(String input) {
        final String[] str = input.split("[+ \\- *]");

        List<String> strAll = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            strAll.add(str[i]);
        }

        int i = 0;
        for (int j = 0; j < input.length(); j++) {
            if (input.charAt(j) == '+' || input.charAt(j) == '-' || input.charAt(j) == '*') {
                strAll.add(2*i+1,input.charAt(j)+"");
                i++;
            }
        }

        compute(strAll);

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        return list;
    }

    public static void compute(List<String> strAll) {
        // 符号个数
        int n = (strAll.size()-1)/2;

        if (n == 1) {
            int result = handle(strAll.get(0), strAll.get(2), strAll.get(1));
            if (!list.contains(result)) {
                list.add(result);
            }
            return;
        }




        for (int i = 0; i < n; i++) {
            int t = handle(strAll.get(2*i), strAll.get(2*i+2), strAll.get(2*i+1));
            String r1 = strAll.remove(2*i);
            String r2 = strAll.remove(2*i);
            String r3 = strAll.remove(2*i);
            strAll.add(2*i,t+"");
            compute(strAll);
            strAll.remove(2*i);
            strAll.add(2*i,r1);
            strAll.add(2*i+1,r2);
            strAll.add(2*i+2,r3);
        }
    }


    public static int handle(String a, String b, String operator) {
        if (operator.charAt(0) == '+') {
            return Integer.parseInt(a)+Integer.parseInt(b);
        } else if (operator.charAt(0) == '-') {
            return Integer.parseInt(a)-Integer.parseInt(b);
        } else {
            return Integer.parseInt(a)*Integer.parseInt(b);
        }
    }

    // 分治法，碰到运算符号，递归求解前一半的值和后一半的值，然后根据运算符号，计算两者构成的值。
    public static Map<String, List<Integer>> map = new HashMap<>();
    // 记录已经计算出来的字符串对应的值，避免重复计算。
    public static List<Integer> diffWaysToCompute2(String input) {
        if(map.containsKey(input)) return map.get(input);
        List<Integer> list = new ArrayList<>();
        int len = input.length();
        for(int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {  // 出现运算符号，递归求解前半段和后半段。
                List<Integer> left = diffWaysToCompute2(input.substring(0, i));
                List<Integer> right = diffWaysToCompute2(input.substring(i+1, input.length()));
                // -1   =>  left:[[0]]  right:[[1]]

                for(int l : left) {
                    for(int r : right) {
                        switch(c) {
                            case '+':
                                list.add(l + r);
                                break;
                            case '-':
                                list.add(l - r);
                                break;
                            case '*':
                                list.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if(list.size() == 0) list.add(Integer.valueOf(input));
        // 单独一个数字的情况 (可能出现多位数)
        map.put(input, list);
        return list;
    }




    public static void main(String[] args) {
        diffWaysToCompute("2*3-4*5");
        System.out.println(list);

        System.out.println(diffWaysToCompute2("2*3-4*5"));



    }
}

