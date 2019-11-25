package cn.wishhust.algorithm;

import java.util.Scanner;

/**
 *
 * 题目： 一个圆桌，n个人，相邻两人身高差不超过m，所有排列方法。 （类似于8皇后问题）
 *
 * 说明：
 * m    身高差限制
 * n    人数
 * arr  身高数据
 * seat 实际座位身高下标
 * 8 皇后解法
 *
 */

public class Demo019 {
    // 方法数
    public static int count = 0;

    public static void solution(int [] seat, int [] arr, int m) {
        // 固定 第一个位置，
        seat[0] = 0;
        fun(seat,arr,1,m);
    }

    // 主要函数
    public static void fun(int [] seat, int[] arr, int step, int m) {

        if (step == arr.length) {
            // 判断最后一人与第一人的身高差是否满足要求
            if (Math.abs(arr[seat[0]]-arr[seat[step-1]]) <= m) {
                count++;
            }
            return;
        }

        // 递归回溯
        for (int i = 1; i < arr.length; i++) {
            // check 检测下标重复（不能出现相同的人占同一位置）
            if (check(seat, i, step) && Math.abs(arr[seat[step-1]]-arr[i]) <= m) {
                seat[step] = i;
                // 递归安排下一个人的位置
                fun(seat,arr,step+1,m);
            }
        }

    }


    // check 检测下标重复，
    public static boolean check(int [] seat, int index, int step) {
        for (int i = 0; i < step; i++) {
            if (seat[i] == index) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int [] arr = new int[n];
        int [] seat = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        solution(seat, arr, m);
        System.out.println(count);

    }

}
