package cn.wishhust.leetcode;
import java.util.*;

public class Demo1029 {

    public static int twoCitySchedCost(int[][] costs) {

        int n = costs.length;
        int result = 0;
        int a = n / 2;
        int b = n / 2;

        // 存放差值
        int [] diff = new int [n];

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(costs[i][0] - costs[i][1]);
        }
        int [] indexDiff = new int [n];

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 1; j < n; j++) {
                if (diff[max] < diff[j])
                    max = j;
            }
            diff[max] = -1;
            indexDiff[i] = max;
        }

        int i = 0;
        for (; i < n; i++) {
            int index = indexDiff[i];
            // 去a市
            if (costs[index][0] - costs[index][1] < 0) {
                result += costs[index][0];
                a--;
            // 去b市
            } else {
                result +=costs[index][1];
                b--;
            }

            if (a == 0 || b == 0) {
                break;
            }
        }


        while (a != 0){
            int index = indexDiff[++i];
            result += costs[index][0];
            a--;
        }


        while (b != 0) {
            int index = indexDiff[++i];
            result += costs[index][1];
            b--;
        }



        return result;
    }

    public static void main(String[] args) {
        int [][] costs = new int [][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        System.out.println(twoCitySchedCost(costs));
    }
}
