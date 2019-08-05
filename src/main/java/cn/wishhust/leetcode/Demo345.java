package cn.wishhust.leetcode;
public class Demo345 {

    public static String reverseVowels(String s) {

        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        int j = s.length()-1;
        while (i < j) {
            while (i < s.length() && !isVowel(s.charAt(i))) {
                i++;
            }
            while (j >= 0 && !isVowel(s.charAt(j))) {
                j--;
            }
            if (i < j) {
                sb.setCharAt(i, s.charAt(j));
                sb.setCharAt(j, s.charAt(i));
                i++;j--;
            }
        }
        return sb.toString();

    }

    public static boolean isVowel(char c) {
        if (c == 'a'|| c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A'|| c == 'E' || c == 'I' || c == 'O' || c == 'U'
            ) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels(".,"));
    }

}
