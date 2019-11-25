package cn.wishhust.test;

import java.util.*;

public class Test2019082401 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();


        int [] x = new int[m];
        int [] y = new int[m];

        Map<Integer, List<Integer>> relationMap = new HashMap<>();
        int [] relation = new int[2*n+1];

        for (int i = 0; i < m; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
            relation[x[i]]++;
            relation[y[i]]++;
            if (relationMap.containsKey(x[i])) {
                relationMap.get(x[i]).add(y[i]);
            } else {
                List<Integer> integers = new ArrayList<>();
                integers.add(y[i]);
                relationMap.put(x[i], integers);
            }

            if (relationMap.containsKey(y[i])) {
                relationMap.get(y[i]).add(x[i]);
            } else {
                List<Integer> integers = new ArrayList<>();
                integers.add(x[i]);
                relationMap.put(y[i], integers);
            }
        }
        List<Integer> stuNo = new ArrayList<>();

        while (m>0) {
            Integer key = findMax(relationMap);
            stuNo.add(key);
            relation[key]--;
            for(Integer r : relationMap.get(key)) {
                relation[r]--;
                m--;
            }
            for (int i = 0; i < relationMap.get(key).size(); i++) {
                Integer integer = relationMap.get(key).get(i);
                relationMap.get(integer).remove(key);
            }
            relationMap.remove(key);
        }
        System.out.println(stuNo.size());
        for (int i = 0; i < stuNo.size(); i++) {
            System.out.print(stuNo.get(i) + " ");
        }



    }

    public static Integer findMax(Map<Integer, List<Integer>> map) {
        int maxSize = -1;
        int maxKey = map.keySet().iterator().next();
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            if(maxSize < e.getValue().size()) {
                maxSize = e.getValue().size();
                maxKey = e.getKey();
            }
        }
        return maxKey;
    }


}
