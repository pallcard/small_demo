package cn.wishhust.leetcode;
public class Demo680 {
    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        int tolerant = 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else if (tolerant > 0) {
                tolerant--;
                if (i+1<s.length() && s.charAt(i+1) == s.charAt(j) && j-1>=0 && s.charAt(j-1) == s.charAt(i)) {
                    // cupucu
                    if (i+2<s.length() && j-1>=0  && s.charAt(i+2)== s.charAt(j-1)) {
                        i++;
                    } else {
                        j--;
                    }

                } else if(i+1<s.length() && s.charAt(i+1) == s.charAt(j)) {
                    i++;
                } else {
                    j--;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean validPalindrome2(String s) {
        int i = 0;
        int j = s.length()-1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return validPalindrome3(s.substring(i,j)) || validPalindrome3(s.substring(i+1,j+1));
            }
        }
        return true;
    }

    public static boolean validPalindrome3(String s) {
        int i = 0;
        int j = s.length()-1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("aeacdeaeaaaaaaeaedcae"));
        System.out.println(validPalindrome2("aeacdeaeaaaaaaeaedcae"));
    }
}
