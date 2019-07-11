package main.java.cn.wishhust.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1）按区间结尾排序
 * 2）每次选择结尾最小，且与前一个区间不重叠
 *
 */

public class Demo435 {



    public static int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        // 无重叠的子区间的个数
        int count = 1;

        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.length-count;
    }

    public static void main(String[] args) {
        eraseOverlapIntervals(new int[][]{{1,100},{11,22},{1,11},{2,12}});
    }
}
