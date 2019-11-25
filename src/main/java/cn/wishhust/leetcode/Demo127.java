package cn.wishhust.leetcode;
import java.util.*;

/**
 * 127. 单词接龙
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 *
 *
 */

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
