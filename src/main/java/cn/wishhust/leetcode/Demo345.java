package cn.wishhust.leetcode;

/**
 *
 * 345. 反转字符串中的元音字母
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 *
 */

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
