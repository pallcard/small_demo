package cn.wishhust.leetcode;
import java.util.*;

public class Demo127 {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }
        wordList.add(beginWord);

        wordList.remove(endWord);
        Queue<String> queue = new LinkedList<>();
        queue.add(endWord);
        int level = 1;
        while (!queue.isEmpty()) {
            // 用于确定当前bfs到第几层
            int size = queue.size();
            level++;
            while (size-- > 0) {
                String top = queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    String word = wordList.get(i);
                    if(isDifferentOnlyOne(top, word)) {
                        if (word.equals(beginWord)) {
                            return level;
                        }
                        queue.add(word);
                        wordList.remove(word);
                    }
                }

            }
        }
        return 0;

    }

    public static boolean isDifferentOnlyOne(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int count = 1;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(ladderLength("hit", "cog", list));
    }


}
