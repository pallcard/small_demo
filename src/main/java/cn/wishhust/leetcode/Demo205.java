package cn.wishhust.leetcode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 205. 同构字符串
 *
 *给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 *
 *
 */

public class Demo205 {
    public static boolean isIsomorphic(String s, String t) {
//        int [][] integers = new int [58][];
//
////        List<List<Integer>> list = new ArrayList<>(58);
//        for (int i = 0; i < s.length(); i++) {
////            if (null == list.get(s.charAt(i)-'a')) {
//
////            }
//            int index = integers[s.charAt(i) - 'a'].length;
//            integers[s.charAt(i)-'a'][] = i;
//            list.get(s.charAt(i)-'a').add(i);
////            list.add(s.charAt(i)-'a', );
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            List<Integer> integers = list.get(i);
//            char c = ' ';
//            for (int j = 0; j < integers.size(); j++) {
//                if (j == 0) {
//                   c = t.charAt(integers.get(j));
//                } else if (c != t.charAt(integers.get(j))){
//                    return false;
//                }
//            }
//        }
//        return true;


        // 记录改字符上次出现的位置，如果都相同则属于同构
        int [] preIndexOfS = new int[256];
        int [] preIndexOfT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (preIndexOfS[sc] != preIndexOfT[tc]) {
                return false;
            }

            preIndexOfS[sc] = i+1;
            preIndexOfT[tc] = i+1;

        }
        return true;


    }

    public static void main(String[] args) {
        isIsomorphic("egg", "add");
    }
}
