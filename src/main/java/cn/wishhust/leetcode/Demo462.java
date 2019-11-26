package cn.wishhust.leetcode;
import java.util.Arrays;

/**
 * 462. 最少移动次数使数组元素相等 II
 *
 * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。
 *
 * 例如:
 *
 * 输入:
 * [1,2,3]
 *
 * 输出:
 * 2
 *
 * 说明：
 * 只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）：
 *
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 *
 */

public class Demo462 {

    // 方法一
    // 若a,b移动到m（中位数）时最小，移动次数为 m-a + b-m  = b -a
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int i = 0;
        int j = nums.length-1;
        while (i < j) {
            count += nums[j]-nums[i];
            i++;j--;
        }
        return count;
    }

    // 方法二，求出中位数，==> 求第k大的数（k=n/2) ==> 快排
    public static int minMoves3(int[] nums) {
        final int kMax = findKMax(nums, 0, nums.length - 1, (nums.length+1)/2);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += Math.abs(nums[i]-kMax);
        }
        return count;
    }

    // 找第k大的数
    public static int findKMax(int [] nums, int start, int end, int k) {
        int flag = nums[start];
        int i = start+1;
        int j = end;
        while (i <= j) {
            while (i <= end && nums[i] <= flag) {
                i++;
            }
            while (j >= start && nums[j] > flag) {
                j--;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        if (end - j + 1 == k) {
            return flag;
        } else if (end - j + 1 > k) {
            return findKMax(nums, j+1, end, k);
        } else {
            return findKMax(nums, start+1, j, k - (end - j + 1));
        }
    }

    public static void main(String[] args) {
        System.out.println(minMoves3(new int [] {1,2,3}));
    }

}
