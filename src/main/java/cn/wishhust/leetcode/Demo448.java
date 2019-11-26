package cn.wishhust.leetcode;
import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 *
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 *
 *
 */

public class Demo448 {
    // 方法一：利用下标，将数组中元素对应的下标的元素置负数，看最终数组中不为负数的下标即为所求
    // 方法二：利用下标，使其与对应的位置交换
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            if (nums[Math.abs(nums[i])-1]> 0) {
                nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0) {
                list.add(i+1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int [] {4,3,2,7,8,2,3,1} ));
    }
}
