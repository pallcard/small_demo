package main.java.cn.wishhust.leetcode;

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
