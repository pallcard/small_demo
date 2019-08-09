package cn.wishhust.leetcode;

import java.util.*;



public class Demo632 {
    public static int[] smallestRange(List<List<Integer>> nums) {
//        Queue<int []> queue = new PriorityQueue<>();
//        Queue<int []> queue = new LinkedList<>();
        List<int []> list = new ArrayList<>();

        int [] index = new int[nums.size()];
        int cur = 0;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                list.add(new int [] {nums.get(i).get(j), i});
            }
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int i = 0;
        int j = 0;
//        boolean flag = true;
        int [] result = new int[]{0, Integer.MAX_VALUE};
        while (i<list.size() || j<list.size()) {
            if (cur == nums.size() && result[1]-result[0] > list.get(j-1)[0]-list.get(i)[0]) {
                result[1] = list.get(j-1)[0];
                result[0] = list.get(i)[0];
                i++;
                index[list.get(i)[1]]--;
                if (index[list.get(i)[1]] == 0) {
                    cur--;
                }
            }
            if(j<list.size()) {
                if (index[list.get(j)[1]]==0) {
                    cur++;
                }
                index[list.get(j)[1]]++;
                j++;
//                if (j == list.size()-1) {
//                    flag = false;
//                }
//                if (j<list.size()-1) {
//                    j++;
//                }
            }else{
                i++;
            }
//            if (!flag) {
//                i++;
//            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(1);
        int[] ints = smallestRange(Arrays.asList(Arrays.asList(4, 10, 15, 24, 26), Arrays.asList(0, 9, 12, 20), Arrays.asList(5, 18, 22, 30)));
        System.out.println(ints[0]+""+ints[1]);
    }
}
