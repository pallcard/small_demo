package main.java.cn.wishhust.leetcode;

public class Demo167 {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        while (i < j && numbers[i] + numbers[j] != target) {

            if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }

//        if (numbers[i] + numbers[j] == target) {
            return new int[]{i+1, j+1};
//        }
    }
}
