package main.java.cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Demo763 {

    public static List<Integer> partitionLabels(String S) {

        List<Integer> result = new ArrayList<>();

        int start = 0;
        int end = 0;
        int currLength = 1;

        for (int i = 0; i < S.length(); i++) {
            char curr = S.charAt(i);
            if (end < S.lastIndexOf(curr)) {
                end = S.lastIndexOf(curr);
                currLength = end - start+1;
            }

            if (i == end) {
                result.add(currLength);
                start = i+1;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
