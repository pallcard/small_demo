package cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 254. 因子的组合
 *
 */

public class Demo254 {

    private static List<List<Integer>> list = new ArrayList<>();

    public static List<List<Integer>> getFactors(int n) {
        List<Integer> integers = new ArrayList<>();
        dps(n, integers, 2);
        return list;
    }

    public static void dps(int n, List<Integer> integers, int pre) {

        for (int i = pre; i <= Math.sqrt(n); i++) {
            if (n % i == 0 && n / i >= i) {
                integers.add(i);
                integers.add(n/i);
                list.add(new ArrayList<>(integers));
                integers.remove(integers.size()-1);
                dps(n/i, integers,i);
                integers.remove(integers.size()-1);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(getFactors(36));
    }
}
