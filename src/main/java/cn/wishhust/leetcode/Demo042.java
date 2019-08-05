package cn.wishhust.leetcode;

public class Demo042 {
    public static int trap(int[] height) {

        int [] maxHeight = new int[height.length];
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            maxHeight[i] = height[i];
            if (height[i] > height[maxIndex]) {
                maxIndex = i;
            }
        }

        for(int i = height.length-1; i > maxIndex; i--) {
            if (maxHeight[i] > maxHeight[i-1]) {
                maxHeight[i-1] = maxHeight[i];
            }
        }

        for (int i = 0; i < maxIndex; i++) {
            if (maxHeight[i] > maxHeight[i+1]) {
                maxHeight[i+1] = maxHeight[i];
            }
        }

        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max += maxHeight[i] - height[i];
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
