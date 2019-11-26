package cn.wishhust.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 406. 根据身高重建队列
 *
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 *
 */
public class Demo406 {
    public static int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (a,b) -> a[0]!=b[0] ? b[0]-a[0] : a[1]-b[1]);

//        List<Integer> resultIndex = new ArrayList<>(people.length);
//
//
//        for (int i = 0; i < people.length; i++) {
//            resultIndex.add(people[i][1],i);
//        }
//
//        int [][] result = new int[people.length][];
//
//        for (int i = 0; i < people.length; i++) {
//            result[i] = people[resultIndex.get(i)];
//        }
//
//        return result;

        List<int []> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]);
        }

        return list.toArray(new int [list.size()][]);





    }

    public static void main(String[] args) {
        reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
    }
}
