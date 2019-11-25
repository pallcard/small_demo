package cn.wishhust.leetcode;

/**
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 双指针法
 */
public class Demo009 {
    public boolean isPalindrome(int x) {
        if (x<0) {
            return false;
        }

        String s = new String(x+"");
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x<0 || x%10==0) {
            return false;
        }
        if (x== 0) {
            return true;
        }
        // 右边反向生成数字
        int right = 0;
        while (x>right) {
            right = right*10+x%10;
            x/=10;
        }
        return x==right || x==right/10;
    }


}
