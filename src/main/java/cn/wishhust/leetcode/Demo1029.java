package cn.wishhust.leetcode;
import java.util.*;

/**
 * 1029. 两地调度
 *
 * 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
 *
 * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 *
 *  
 *
 * 示例：
 *
 * 输入：[[10,20],[30,200],[400,50],[30,20]]
 * 输出：110
 * 解释：
 * 第一个人去 A 市，费用为 10。
 * 第二个人去 A 市，费用为 30。
 * 第三个人去 B 市，费用为 50。
 * 第四个人去 B 市，费用为 20。
 *
 * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
 *  
 *
 * 提示：
 *
 * 1 <= costs.length <= 100
 * costs.length 为偶数
 * 1 <= costs[i][0], costs[i][1] <= 1000
 *
 */

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
