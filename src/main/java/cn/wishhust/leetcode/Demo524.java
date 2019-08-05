package cn.wishhust.leetcode;
import java.util.ArrayList;
import java.util.List;

public class Demo524 {
    public static String findLongestWord(String s, List<String> d) {
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < d.size(); i++) {
            int length = d.get(i).length();
            if (isSubString(s, d.get(i)) && length > max) {
                max = length;
                maxIndex = i;
            } else if (isSubString(s, d.get(i)) && length == max) {
                if (d.get(i).compareTo(d.get(maxIndex))<0) {
                    maxIndex = i;
                }
            }
        }
        if (max == 0) {
            return "";
        } else {
            return d.get(maxIndex);
        }
    }

    public static boolean isSubString(String s, String sub) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < sub.length()) {
            if (s.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (j == sub.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        final ArrayList<String> strings = new ArrayList<>();
        strings.add("ba");
        strings.add("ab");
        strings.add("b");

        System.out.println(findLongestWord("bab",strings));
    }
}
