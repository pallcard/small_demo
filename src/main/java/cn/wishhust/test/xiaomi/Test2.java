package cn.wishhust.test.xiaomi;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Test2 {
    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    public static boolean flag = true;
    static void solution(int[] prices, int budget) {
        Arrays.sort(prices);
        int minCount = 0;
        dps(prices,budget, minCount);
        if (flag) {
            System.out.println(-1);
        }
    }
    static void dps(int[] prices, int budget, int minCount) {
        if (budget < 0) {
            return;
        }
        if (budget == 0) {
            flag = false;
            System.out.println(minCount);
        }
        for (int i = prices.length-1 ; i >= 0 && flag; i--) {
            budget = budget-prices[i];
            dps(prices, budget, minCount+1);
            budget = budget+prices[i];
        }
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _prices_size = 0;
        _prices_size = Integer.parseInt(in.nextLine().trim());
        int[] _prices = new int[_prices_size];
        int _prices_item;
        for(int _prices_i = 0; _prices_i < _prices_size; _prices_i++) {
            _prices_item = Integer.parseInt(in.nextLine().trim());
            _prices[_prices_i] = _prices_item;
        }

        int _budget;
        _budget = Integer.parseInt(in.nextLine().trim());

        solution(_prices, _budget);
    }
}
