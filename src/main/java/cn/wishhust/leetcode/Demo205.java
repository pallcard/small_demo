package cn.wishhust.leetcode;
import java.util.ArrayList;
import java.util.List;

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
