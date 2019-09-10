package cn.wishhust.test.huawei;

import java.util.*;

public class Test2 {
    public static int m , n, count;
    public static List<Map> list;
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        list = new ArrayList<>();
        Map<Integer, Integer> integers = new TreeMap<>();
        dps(integers, 0);
        System.out.println(count % 1000000007);
    }
    public static void dps(Map<Integer, Integer> integers, int sdep) {
        if (sdep == m) {
            if (!list.contains(integers)) {
                count++;
                list.add(new TreeMap(integers));
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (integers.containsKey(i)) {
                integers.put(i,integers.get(i)+1);
            } else {
                integers.put(i,1);
            }
            dps(integers, sdep+1);
            if (integers.get(i)-1 == 0) {
                integers.remove(i);
            } else {
                integers.put(i,integers.get(i)-1);
            }
        }

    }
}
