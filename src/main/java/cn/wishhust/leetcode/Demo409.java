package cn.wishhust.leetcode;

/**
 * 409. 最长回文串
 *
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 */


public class Demo409 {

    // 题目读错了
//    public static int longestPalindrome(String s) {
//        int longest = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i+1; j < s.length()+1; j++) {
//                if (isPalinrome(s.substring(i,j))){
//                    longest = Math.max(longest, j-i);
//                }
//            }
//        }
//        return longest;
//    }
//
//    private static boolean isPalinrome(String s) {
//        for (int i = 0; i < s.length()/2; i++) {
//            if (s.charAt(i) != s.charAt(s.length()-i-1)) {
//                return false;
//            }
//        }
//        return true;
//    }

    public int longestPalindrome(String s) {
        int [] cnts = new int [58];

        for (int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i)-'A']++;
        }
        int longest = 0;
        boolean isExist = false;
        for (int i = 0; i < cnts.length; i++) {
            if (cnts[i]>=2) {
                longest += (cnts[i] / 2 * 2);
            }
            if (cnts[i]%2 != 0){
                isExist = true;
            }
        }
        if (isExist) {
            longest++;
        }
        return longest;
    }



    public static void main(String[] args) {
        System.out.println('z'-'A');
    }
}
