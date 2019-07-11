package main.java.cn.wishhust.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Demo452 {
    public static int findMinArrowShots(int[][] points) {

        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        // 不重叠区间个数
        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                count++;
                end = points[i][1];
            }
        }


        return count;
    }

    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
    }
}
