package cn.wishhust.leetcode;
public class Demo367 {

    // 16 = 1 + 3 + 5 + 7
    // 25 = 1 + 3 + 5 + 7 + 9
    // 完全平方数 一定可以写成一个上述的和(等差数列)
    public boolean isPerfectSquare(int num) {
        int temp = 1;
        while (num > 0) {
            if (num - temp == 0) {
                return true;
            } else {
                num -= temp;
                temp += 2;
            }
        }
        return false;
    }
}
