package cn.wishhust.leetcode;
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
