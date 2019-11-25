package cn.wishhust.test;

public class WangYi01 {

    public static int count(int num) {
        int count = 8;
        while (num/2 != 0) {
            if (num%2!=0) {
                count++;
            }
            num /= 2;
        }
        return count;
    }

    public static void main(String[] args) {
        // 存放统计个数
        int [] result = new int [100];
        int n = 10;
        // 输入的数组
        int [] nums = new int[n];
        for (int i = 0; i < n; i++) {
            result[count(nums[i])]++;
        }
        // 最终结果
        int r = 0;
        for (int i = 0; i < 100; i++) {
            if (result[i] > 0) {
                r++;
            }
        }
    }
}
