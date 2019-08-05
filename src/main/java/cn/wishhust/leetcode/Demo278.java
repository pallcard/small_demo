package cn.wishhust.leetcode;
public class Demo278 {

    public boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
//            这样有可能left+right后超过int最大值
//            int mid = (left+right)/2;
            int mid =  left + (right - left) / 2;
            if(!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return left;
    }
}
