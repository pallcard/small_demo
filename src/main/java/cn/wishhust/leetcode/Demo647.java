package cn.wishhust.leetcode;
public class Demo647 {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length()+1; j++) {
                if (isPalinrome(s.substring(i,j))){
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isPalinrome(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }


    // 中心向两端扩张
    static int cnt = 0;
    public static int countSubstrings2(String s) {


        for (int i = 0; i < s.length(); i++) {
            // 子串为奇数个字符
            extendSubstrings(s,i,i);
            // 子串为偶数个字符
            extendSubstrings(s,i,i+1);
        }
        return cnt;
    }

    private static void extendSubstrings(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            cnt++;
        }
    }

    public static void main(String[] args) {
        countSubstrings2("aaa");
    }
}
