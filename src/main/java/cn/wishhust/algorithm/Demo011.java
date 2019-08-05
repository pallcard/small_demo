package cn.wishhust.algorithm;

/**
 * 旋转数组(非递减)的最小数
 * 把一个数组最开始的若干位搬到数组的末尾，称为旋转数组。
 *
 *
 */

public class Demo011 {
    public static void main(String[] args) {
        int [] arr = new int[] {1,1,1,0,1};
        System.out.println(searchMin(arr,arr.length));
    }

    public static int searchMin(int [] array, int length) {
        int left = 0, right = length - 1;
        int mid = (left + right) / 2;
        while(left < right) {
            // 分区间后刚好左右都为非递减数组
            if(array[left] < array[mid] && array[mid+1] < array[right]) {
                if (array[left] > array[mid+1]) {
                    left = mid+1;
                }
                break;
            }
            // 无法分区间情况
            if (array[left] == array[mid] && array[mid] == array[right]) {
                int minIndex = left;
                for (int i = left; i <= right; i++) {
                    if (array[minIndex] > array[i]) {
                        minIndex = i;
                    }
                }
                left = minIndex;
                break;
            }
            // 正常分区间
            if (array[left] < array[mid]) {
                // 左侧为非递减数组，右侧为旋转数组==>取右侧
                left = mid+1;
            } else {
                // 取左侧
                right = mid - 1;
            }
        }
        return array[left];
    }
}
