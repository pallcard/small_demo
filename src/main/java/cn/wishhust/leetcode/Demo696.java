package cn.wishhust.leetcode;
public class Demo696 {
    public int countBinarySubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length()+1; j++) {
                if (isEqual01(s.substring(i,j))) {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isEqual01(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count++;
            } else {
                count--;
            }
        }
        for (int i = 1; i < s.length()/2; i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                return false;
            }
        }
        return count==0;
    }

    public int countBinarySubstrings2(String s) {
        // pre 前一个数字连续出现的次数，cur 当前数字连续出现的次数，count 结果子串个数
        int pre = 0, cur = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }
//            前一个数字出现的次数 >= 后一个数字出现的次数，则一定包含满足条件的子串
            if (pre >= cur) {
                count++;
            }

        }
        return count;
    }

}
