package cn.wishhust.leetcode;
public class Demo172 {
    // 对于一个数 N，它所包含 5 的个数为：N/5 + N/52 + N/53 + ...，
    public int trailingZeroes(int n) {
        int temp = 5;
        int count = 0;
        while (n>5) {
            count += n/5;
            n /= 5;
        }
        return count;
    }
}
