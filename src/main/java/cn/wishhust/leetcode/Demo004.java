package cn.wishhust.leetcode;

public class Demo004 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int low1 = 0, high1 = nums2.length-1;
//        int low2 = 0, high2 = nums2.length-1;
//        int mid1 = low1 + (high1 - low1) / 2;
//        int mid2 = low2 + (high2 - low2) / 2;
//        while (low1 < high1 && low2 < high2 && nums1[mid1] != nums2[mid2]) {
//            if (nums1[mid1] < nums2[mid2]) {
//                low1 = mid1;
//                high2 = mid2;
//            } else {
//                high1 = mid1;
//                low2 = mid2;
//            }
//        }

        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int [] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            int temp1 = m;
            m = n;
            n = temp1;
        }
        // 对短的数组进行二分来确定i，j=(m+n+1)/2-i;
        int low = 0;
        int high = m;
        int mid = (m+n+1)/2;
        while (low <= high) {
            int i = low + (high-low)/2;
            int j = mid - i;

            if (i > low && nums1[i-1] > nums2[j]) {
                high = i - 1;
            } else if (i < high && nums2[j-1]>nums1[i]) {
                low = i + 1;
            } else {
                int maxLeft = 0;
                // num1 < num2
                if (i == 0) {
                    maxLeft = nums2[j-1];
                // num1 > num2
                } else if(j == 0) {
                    maxLeft = nums1[i-1];
                } else {
                    maxLeft = Math.max(nums1[i-1],nums2[j-1]);
                }

                if ((m+n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft+minRight) /2.0 ;
            }


        }
        return 0.0;

    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] {1,2}, new int[]{-1,3}));
    }

}
