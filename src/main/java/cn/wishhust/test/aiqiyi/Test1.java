package cn.wishhust.test.aiqiyi;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static BigInteger count = new BigInteger("0");
    public static int [] condition;

    public static void permute(int[] nums) {
        List<Integer> string = new ArrayList<>();
        // visitedÊý×é
        boolean[] visited = new boolean[nums.length];
        permute(nums,visited, string, 0);
    }

    public static boolean cheak(List<Integer> string) {
        for (int i = 0; i < condition.length; i++) {
            if (condition[i] == 1) {
                if (string.get(i) <= string.get(i+1)) {
                    return false;
                }
            } else {
                if (string.get(i) >= string.get(i+1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void permute(int [] nums, boolean [] visited, List<Integer> string, int k) {
        if (k == nums.length) {
            count = count.add(new BigInteger("1"));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (k==0 || k>0 && (condition[k-1]==1 && nums[i] < string.get(string.size()-1)
                        || (condition[k-1]==0 && nums[i] > string.get(string.size()-1)))) {
                    string.add(nums[i]);
                    visited[i] = true;
                    permute(nums, visited, string, k+1);
                    string.remove(string.size()-1);
                    visited[i] = false;
                }

            }

        }
    }


    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int [] array = new int [N];
        condition = new int [N-1];
        for (int i = 0; i < N; i++) {
            array[i] = i+1;
            if (i < N-1) {
                condition[i] = scanner.nextInt();
            }
        }
        permute(array);
        System.out.println(count.remainder(new BigInteger("10000000007")));
    }
}
