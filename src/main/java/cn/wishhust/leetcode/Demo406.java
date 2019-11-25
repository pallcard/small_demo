package cn.wishhust.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
