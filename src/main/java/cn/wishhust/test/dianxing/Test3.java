package cn.wishhust.test.dianxing;

import java.util.Scanner;

public class Test3 {
    public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i-1]+nums[i]);
            sum = Math.max(sum, nums[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String s = scanner.nextLine();
        // [2, 4, -2, 5, -6]
        final String[] split = s.substring(1, s.length() - 1).split(", ");
        int [] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        System.out.println(maxSubArray(arr));
    }
}
