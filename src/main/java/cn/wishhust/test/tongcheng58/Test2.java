package cn.wishhust.test.tongcheng58;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] a = new int [n];
        int [] nums = new int [n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            nums[i] = 1;
        }
        // 3 6 3 5 6 2
        // 1 2 1 2 3 1
        // 6 3
        // 1 1
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < n-1; i++) {
                if (a[i] < a[i+1] && nums[i] >= nums[i+1]) {
                    nums[i+1] = nums[i]+1;
                    flag = true;
                } else if (a[i] > a[i+1] && nums[i] <= nums[i+1]) {
                    nums[i] = nums[i+1]+1;
                    flag = true;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        System.out.println(sum);


    }
}
