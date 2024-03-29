package cn.wishhust.leetcode;
import java.util.Arrays;
import java.util.Stack;


/**
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 *
 */
public class Demo503 {

    public int[] nextGreaterElements(int[] nums) {

        int [] dist = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int j = i+1;
            j = j % nums.length;
            while (j != i && nums[j] <= nums[i]) {
                j++;
                j = j % nums.length;
            }
            if (nums[j] > nums[i]) {
                dist[i] = nums[j];
            } else {
                dist[i] = -1;
            }

        }
        return dist;

    }

    public int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int [] dist = new int[n];
        Arrays.fill(dist, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n*2; i++) {
            int num = nums[i%n];
            while (!stack.isEmpty() && nums[stack.peek()]< num) {
                dist[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return dist;

    }

}
